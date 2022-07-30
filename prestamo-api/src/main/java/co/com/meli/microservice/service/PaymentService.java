/**
 * 
 */
package co.com.meli.microservice.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import co.com.meli.microservice.dto.PaymentRequestModel;
import co.com.meli.microservice.dto.PaymentResponseModel;
import co.com.meli.microservice.persistence.data.Loan;
import co.com.meli.microservice.persistence.data.Payment;
import co.com.meli.microservice.repository.ILoanRepository;
import co.com.meli.microservice.repository.IPaymentRepository;
import co.com.meli.microservice.util.CommonUtil;
import co.com.meli.microservice.util.MapperUtil;
import lombok.AllArgsConstructor;

/**
 * @author juan.mosquera
 *
 */
@Service(value = "paymentService")
@AllArgsConstructor
public class PaymentService implements IPaymentService {

    private IPaymentRepository paymentRepository;
    private ILoanRepository loanRepository;
    private MapperUtil mapperUtil;

    @Override
    public PaymentResponseModel savePayment(PaymentRequestModel requestModel) {
        Payment payment = null;
        Payment entity = null;
        PaymentResponseModel response = null;
        Double debt = null;

        payment = mapperUtil.paymentRequestModelToPayment(requestModel);
        entity = paymentRepository
                .save(buildPaymentEntity(payment, requestModel));

        debt = getLoanDebt(entity.getLoan());
        if (null == debt) {
            return null;
            // Not implemented yet
        }

        response = mapperUtil.paymenToPaymentResponseModel(entity);
        response.setDebt(debt);

        return response;
    }

    private Payment buildPaymentEntity(Payment payment,
            PaymentRequestModel requestModel) {
        Loan loan = null;
        Double debt = null;

        // TODO Null pointer
        loan = loanRepository.findById(requestModel.getLoanId()).orElse(null);
        if (null == loan) {
            return null;
            // Not implemented yet
        }

        debt = getLoanDebt(loan);
        if (null == debt || payment.getAmount() > debt) {
            return null;
            // Not implemented yet
        }

        payment.setLoan(loan);
        payment.setCreationDate(new Date());

        return payment;
    }

    private Double getLoanDebt(Loan loan) {
        List<Payment> payments = null;

        payments = paymentRepository.findAllByLoan(loan);
        if (null == payments) {
            return null;
            // Not implemented yet
        }

        return CommonUtil.calculateLoanDebt(loan, payments);
    }

    @Override
    public List<Payment> getPaymentsByLoanAndDateRange(Loan loan,
            Date creationDateStart, Date creationDateEnd) {
        return paymentRepository.findAllByLoanAndCreationDateBetween(loan,
                creationDateStart, creationDateEnd);
    }
}
