/**
 * 
 */
package co.com.meli.microservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import co.com.meli.microservice.dto.PaymentRequestModel;
import co.com.meli.microservice.dto.PaymentResponseModel;
import co.com.meli.microservice.exception.BusinessException;
import co.com.meli.microservice.exception.EntityNotFoundException;
import co.com.meli.microservice.exception.NoDataFoundException;
import co.com.meli.microservice.persistence.data.Loan;
import co.com.meli.microservice.persistence.data.Payment;
import co.com.meli.microservice.repository.ILoanRepository;
import co.com.meli.microservice.repository.IPaymentRepository;
import co.com.meli.microservice.util.Constant;
import co.com.meli.microservice.util.MapperUtil;

/**
 * @author juan.mosquera
 *
 */
@SpringBootTest
class PaymentServiceTest {

    @InjectMocks
    private PaymentService paymentService;

    @Mock
    private IPaymentRepository paymentRepository;

    @Mock
    private ILoanRepository loanRepository;

    @Mock
    private MapperUtil mapperUtil;
    
    private PaymentRequestModel requestModel;
    private PaymentResponseModel response;
    private Payment payment;
    private Loan loan;
    private List<Payment> payments;
    private Double debt;
    
    @BeforeEach
    public void setUp() {
        debt = 90D;

        requestModel = new PaymentRequestModel();
        requestModel.setLoanId(1L);
        requestModel.setAmount(100D);

        response = new PaymentResponseModel();
        response.setDebt(debt);
        response.setId(1L);
        response.setLoanId(1L);

        loan = new Loan();
        loan.setId(1L);
        loan.setInstallment(100D);
        loan.setTerm(1);

        payment = new Payment();
        payment.setId(1L);
        payment.setAmount(10D);
        payment.setLoan(loan);

        payments = new ArrayList<>();
        payments.add(payment);
    }

    @Test
    void recordPaymentTest() {
        PaymentResponseModel response = null;
        Payment payment = new Payment();
        payment.setId(1L);
        payment.setAmount(10D);

        when(mapperUtil.paymentRequestModelToPayment(any()))
                .thenReturn(payment);
        when(paymentRepository.findAllByLoan(any())).thenReturn(this.payments);
        when(loanRepository.findById(any())).thenReturn(Optional.of(this.loan));
        when(paymentRepository.save(any()))
                .thenReturn(this.payment);
        when(mapperUtil.paymenToPaymentResponseModel(any()))
                .thenReturn(this.response);
        response = paymentService.savePayment(this.requestModel);

        assertEquals(this.response, response);
    }

    @Test
    void recordPaymentTestWhenLoanNotFoundBuildingEntity() {
        Payment payment = new Payment();

        when(mapperUtil.paymentRequestModelToPayment(any()))
                .thenReturn(payment);
        when(loanRepository.findById(any()))
                .thenThrow(new EntityNotFoundException(
                        String.format(Constant.ERROR_STRING_ENTITY_NOT_FOUND,
                                Loan.class.getSimpleName(),
                                this.requestModel.getLoanId())));

        assertThrows(EntityNotFoundException.class,
                () -> paymentService.savePayment(this.requestModel));
    }

    @Test
    void recordPaymentTestWhenPaymentExceedsDebt() {
        Payment payment = new Payment();
        payment.setId(1L);
        payment.setAmount(10000D);

        when(mapperUtil.paymentRequestModelToPayment(any()))
                .thenReturn(payment);
        when(loanRepository.findById(any())).thenReturn(Optional.of(this.loan));

        assertThrows(BusinessException.class,
                () -> paymentService.savePayment(this.requestModel));
    }

    @Test
    void recordPaymentTestWhenPaymentsNoDataFound() {
        Payment payment = new Payment();
        payment.setId(1L);
        payment.setAmount(10D);

        when(mapperUtil.paymentRequestModelToPayment(any()))
                .thenReturn(payment);
        when(loanRepository.findById(any())).thenReturn(Optional.of(this.loan));
        when(paymentRepository.findAllByLoan(any())).thenReturn(null);

        assertThrows(NoDataFoundException.class,
                () -> paymentService.savePayment(this.requestModel));
    }

}
