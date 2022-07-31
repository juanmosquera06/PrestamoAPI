/**
 * 
 */
package co.com.meli.microservice.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import co.com.meli.microservice.dto.PaymentRequestModel;
import co.com.meli.microservice.dto.PaymentResponseModel;
import co.com.meli.microservice.exception.BusinessException;
import co.com.meli.microservice.exception.EntityNotFoundException;
import co.com.meli.microservice.exception.NoDataFoundException;
import co.com.meli.microservice.persistence.data.Loan;
import co.com.meli.microservice.persistence.data.Payment;
import co.com.meli.microservice.repository.ILoanRepository;
import co.com.meli.microservice.repository.IPaymentRepository;
import co.com.meli.microservice.util.CommonUtil;
import co.com.meli.microservice.util.Constant;
import co.com.meli.microservice.util.MapperUtil;
import lombok.AllArgsConstructor;

/**
 * @author juan.mosquera
 *
 */
@Service(value = Constant.SERVICE_STRING_PAYMENT)
@AllArgsConstructor
public class PaymentService implements IPaymentService {

    private IPaymentRepository paymentRepository;
    private ILoanRepository loanRepository;
    private MapperUtil mapperUtil;

    @Override
    public PaymentResponseModel savePayment(PaymentRequestModel requestModel)
            throws EntityNotFoundException, NoDataFoundException,
            BusinessException {
        Payment payment = null;
        Payment entity = null;
        PaymentResponseModel response = null;

        payment = mapperUtil.paymentRequestModelToPayment(requestModel);
        entity = paymentRepository
                .save(buildPaymentEntity(payment, requestModel));

        response = mapperUtil.paymenToPaymentResponseModel(entity);
        response.setDebt(getLoanDebt(entity.getLoan()));

        return response;
    }

    private Payment buildPaymentEntity(Payment payment,
            PaymentRequestModel requestModel)
            throws EntityNotFoundException, NoDataFoundException,
            BusinessException {
        Loan loan = null;
        Double debt = null;

        loan = loanRepository.findById(requestModel.getLoanId())
                .orElseThrow(() -> new EntityNotFoundException(String.format(
                        Constant.ERROR_STRING_ENTITY_NOT_FOUND,
                        Loan.class.getSimpleName(), requestModel.getLoanId())));

        debt = getLoanDebt(loan);
        if (null == debt) {
            throw new BusinessException(
                    Constant.ERROR_STRING_ERROR_GETTING_LOAN_DEBT);
        }

        if (payment.getAmount() > debt) {
            throw new BusinessException(
                    Constant.ERROR_STRING_PAYMENT_AMOUNT_EXCEEDS_LOAN_DEBT);
        }

        payment.setLoan(loan);
        payment.setCreationDate(LocalDateTime.now());

        return payment;
    }

    private Double getLoanDebt(Loan loan) throws NoDataFoundException {
        List<Payment> payments = null;

        payments = paymentRepository.findAllByLoan(loan);
        if (null == payments) {
            throw new NoDataFoundException(
                    String.format(Constant.ERROR_STRING_NOT_DATA_FOUND,
                            Payment.class.getSimpleName()));
        }

        return CommonUtil.calculateLoanDebt(loan, payments);
    }

}
