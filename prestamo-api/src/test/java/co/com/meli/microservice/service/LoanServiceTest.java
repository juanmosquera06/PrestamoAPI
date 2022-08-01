/**
 * 
 */
package co.com.meli.microservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import co.com.meli.microservice.dto.DebtResponseModel;
import co.com.meli.microservice.dto.InstallmentResponseModel;
import co.com.meli.microservice.dto.LoanRequestModel;
import co.com.meli.microservice.dto.LoanResponseModel;
import co.com.meli.microservice.exception.BusinessException;
import co.com.meli.microservice.exception.DateException;
import co.com.meli.microservice.exception.EntityNotFoundException;
import co.com.meli.microservice.exception.NoDataFoundException;
import co.com.meli.microservice.persistence.data.Client;
import co.com.meli.microservice.persistence.data.Loan;
import co.com.meli.microservice.persistence.data.Payment;
import co.com.meli.microservice.persistence.data.Target;
import co.com.meli.microservice.repository.ILoanRepository;
import co.com.meli.microservice.repository.IPaymentRepository;
import co.com.meli.microservice.util.Constant;
import co.com.meli.microservice.util.MapperUtil;

/**
 * Unit tests of the LoanService class.
 * 
 * @author Juan Felipe Mosquera
 *
 */
@SpringBootTest
class LoanServiceTest {

    @InjectMocks
    private LoanService loanService;

    @Mock
    private ILoanRepository loanRepository;

    @Mock
    private IClientService clientService;

    @Mock
    private IPaymentRepository paymentRepository;

    @Mock
    private MapperUtil mapperUtil;

    private final String STRING_DATE_FROM = "2022-07-30";
    private final String STRING_DATE_INVALID = "2022-07-32";
    private final String STRING_DATE_TO = "2022-07-31";
    private Client client;
    private Loan loan;
    private List<Loan> loans;
    private LoanRequestModel requestModel;
    private LoanResponseModel loanResponseModel;
    private List<LoanResponseModel> loanResponseModels;
    private Map<String, Double> loanConditions;
    private InstallmentResponseModel installmentResponseModel;
    private Payment payment;
    private List<Payment> payments;
    private Double debt;
    private DebtResponseModel response;

    @BeforeEach
    public void setUp() {
        debt = 90D;

        client = new Client();
        client.setId(1L);
        Target target = new Target();
        client.setTarget(target);
        client.getTarget()
                .setDescription(co.com.meli.microservice.enums.Target.NEW);

        loan = new Loan();
        loan.setId(1L);
        loan.setAmount(10000D);
        loan.setRate(0.1D);
        loan.setInstallment(100D);
        loan.setTerm(1);
        loan.setClient(client);
        loan.setCreationDate(LocalDateTime.now());

        loans = new ArrayList<>();
        loans.add(loan);

        requestModel = new LoanRequestModel();
        requestModel.setAmount(10000D);
        requestModel.setTerm(1);
        requestModel.setUserId(1L);

        loanResponseModel = new LoanResponseModel();
        loanResponseModel.setId(1L);

        loanResponseModels = new ArrayList<>();
        loanResponseModels.add(loanResponseModel);

        loanConditions = new HashMap<>();
        loanConditions.put(Constant.LOAN_CONDITION_STRING_RATE, 0D);

        installmentResponseModel = new InstallmentResponseModel();
        installmentResponseModel.setId(1L);
        installmentResponseModel.setInstallment(10000D);

        payment = new Payment();
        payment.setId(1L);
        payment.setAmount(10D);
        payment.setLoan(loan);

        payments = new ArrayList<>();
        payments.add(payment);

        response = new DebtResponseModel();
        response.setDebt(debt);
    }

    @Test
    void findAllLoansByDateRangeTest() {
        List<LoanResponseModel> loanResponseModels = null;
        when(loanRepository.findAllByCreationDateBetween(any(), any()))
                .thenReturn(this.loans);
        when(mapperUtil.loanToLoanResponseModels(any()))
                .thenReturn(this.loanResponseModels);
        loanResponseModels = loanService.findAllLoansByDateRange(
                this.STRING_DATE_FROM, this.STRING_DATE_TO);

        assertEquals(this.loanResponseModels, loanResponseModels);
    }

    @Test
    void findAllLoansByDateRangeTestWhenLoansAreNull() {
        when(loanRepository.findAllByCreationDateBetween(any(), any()))
                .thenReturn(null);

        assertThrows(NoDataFoundException.class,
                () -> loanService.findAllLoansByDateRange(this.STRING_DATE_FROM,
                        this.STRING_DATE_TO));
    }

    @Test
    void findAllLoansByDateRangeTestWhenDateIsInvalid() {
        assertThrows(DateException.class,
                () -> loanService.findAllLoansByDateRange(
                        this.STRING_DATE_INVALID, this.STRING_DATE_TO));
    }

    @Test
    void recordLoanTest() {
        InstallmentResponseModel installmentResponseModel = null;

        when(mapperUtil.loanRequestModelToLoan(any())).thenReturn(this.loan);
        when(clientService.findById(any())).thenReturn(this.client);
        when(clientService.findActiveLoanConditionsByClient(any()))
                .thenReturn(this.loanConditions);
        when(loanRepository.save(any())).thenReturn(this.loan);
        when(mapperUtil.loanToInstallmentResponseModel(any()))
                .thenReturn(this.installmentResponseModel);
        installmentResponseModel = loanService.saveLoan(this.requestModel);

        assertEquals(this.installmentResponseModel, installmentResponseModel);
    }

    @Test
    void recordLoanTestWhenRateIsMissing() {
        Map<String, Double> loanConditions = new HashMap<String, Double>();

        when(mapperUtil.loanRequestModelToLoan(any())).thenReturn(this.loan);
        when(clientService.findById(any())).thenReturn(this.client);
        when(clientService.findActiveLoanConditionsByClient(any()))
                .thenReturn(loanConditions);

        assertThrows(BusinessException.class,
                () -> loanService.saveLoan(this.requestModel));
    }

    @Test
    void getDebtByIdLoanAndDateFilterTest() {
        DebtResponseModel response = null;
        when(loanRepository.findById(any())).thenReturn(Optional.of(this.loan));
        when(paymentRepository.findAllByLoan(any())).thenReturn(this.payments);
        response = loanService.getDebtByIdLoanAndDateFilter(1L,
                Optional.empty());

        assertEquals(this.response, response);
    }

    @Test
    void getDebtByIdLoanAndDateFilterTestWhenLoanNotFound() {
        when(loanRepository.findById(any()))
                .thenThrow(new EntityNotFoundException(
                        String.format(Constant.ERROR_STRING_ENTITY_NOT_FOUND,
                                Loan.class.getSimpleName(), 1L)));

        assertThrows(EntityNotFoundException.class, () -> loanService
                .getDebtByIdLoanAndDateFilter(1L, Optional.empty()));
    }

    @Test
    void getDebtByIdLoanAndDateFilterTestWhenPaymentsAreMissing() {
        when(loanRepository.findById(any())).thenReturn(Optional.of(this.loan));
        when(paymentRepository.findAllByLoan(any())).thenReturn(null);

        assertThrows(NoDataFoundException.class, () -> loanService
                .getDebtByIdLoanAndDateFilter(1L, Optional.empty()));
    }

    @Test
    void getDebtByIdLoanAndDateFilterTestWhenDateIsInvalid() {
        when(loanRepository.findById(any())).thenReturn(Optional.of(this.loan));
        when(paymentRepository.findAllByLoan(any())).thenReturn(this.payments);

        assertThrows(DateException.class,
                () -> loanService.getDebtByIdLoanAndDateFilter(1L,
                        Optional.of(this.STRING_DATE_INVALID)));
    }

    @Test
    void getDebtByTargetAndDateFilterTest() {
        DebtResponseModel response = null;
        when(loanRepository.findAll()).thenReturn(this.loans);
        when(paymentRepository.findAllByLoan(any())).thenReturn(this.payments);
        response = loanService.getDebtByTargetAndDateFilter(Optional.empty(),
                Optional.empty());

        assertEquals(this.response, response);
    }

    @Test
    void getDebtByTargetAndDateFilterTestWhenTargetIsPresent() {
        DebtResponseModel response = null;
        when(loanRepository.findAll()).thenReturn(this.loans);
        when(paymentRepository.findAllByLoan(any())).thenReturn(this.payments);
        response = loanService.getDebtByTargetAndDateFilter(Optional.empty(),
                Optional.of(co.com.meli.microservice.enums.Target.NEW));

        assertEquals(this.response, response);
    }

    @Test
    void getDebtByTargetAndDateFilterTestWhenDateIsPresent() {
        DebtResponseModel response = null;

        when(loanRepository.findAll()).thenReturn(this.loans);
        when(paymentRepository.findAllByLoan(any())).thenReturn(this.payments);
        response = loanService.getDebtByTargetAndDateFilter(
                Optional.of(STRING_DATE_FROM),
                Optional.empty());

        assertNotNull(response);
    }

    @Test
    void getDebtByTargetAndDateFilterTestWhenDateIsInvalid() {
        when(loanRepository.findAll()).thenReturn(this.loans);
        when(paymentRepository.findAllByLoan(any())).thenReturn(this.payments);

        assertThrows(DateException.class,
                () -> loanService.getDebtByTargetAndDateFilter(
                        Optional.of(this.STRING_DATE_INVALID),
                        Optional.empty()));
    }

}
