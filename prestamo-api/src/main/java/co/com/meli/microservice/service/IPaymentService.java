/**
 * 
 */
package co.com.meli.microservice.service;

import java.util.Date;
import java.util.List;

import co.com.meli.microservice.dto.PaymentRequestModel;
import co.com.meli.microservice.dto.PaymentResponseModel;
import co.com.meli.microservice.persistence.data.Loan;
import co.com.meli.microservice.persistence.data.Payment;

/**
 * @author juan.mosquera
 *
 */
public interface IPaymentService {

    public PaymentResponseModel savePayment(PaymentRequestModel requestModel);

    public List<Payment> getPaymentsByLoanAndDateRange(Loan loan,
            Date creationDateStart, Date creationDateEnd);

}
