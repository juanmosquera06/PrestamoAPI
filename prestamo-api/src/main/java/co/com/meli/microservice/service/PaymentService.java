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
 * Business logic that implements IClientService interface. It contains the
 * business logic that allows you to apply payments to a loan and consult the
 * payments associated with it.
 * 
 * @since 0.0.1
 * @author Juan Felipe Mosquera
 * @see IPaymentService
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

    /**
     * Build entity Payment from the request object information.
     * 
     * @param payment
     *            payment information.
     * @param requestModel
     *            DTO with request object information.
     * @return Payment entity.
     * @throws EntityNotFoundException
     *             if loan does not exist.
     * @throws NoDataFoundException
     *             if there is an error getting the previous payments.
     * @throws BusinessException
     *             if any entered value is invalid.
     * @see Payment
     */
    private Payment buildPaymentEntity(Payment payment,
            PaymentRequestModel requestModel)
            throws EntityNotFoundException, NoDataFoundException,
            BusinessException {
        Loan loan = null;
        Double debt = null;

        if (!CommonUtil.isValidNumberValue(requestModel.getAmount())) {
            throw new BusinessException(String.format(
                    Constant.ERROR_STRING_VALUE_IS_NOT_A_VALID_NUMBER,
                    Constant.COMMON_STRING_AMOUNT));
        }

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
