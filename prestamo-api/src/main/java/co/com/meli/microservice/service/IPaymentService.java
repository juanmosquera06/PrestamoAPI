/**
 * 
 */
package co.com.meli.microservice.service;

import co.com.meli.microservice.dto.PaymentRequestModel;
import co.com.meli.microservice.dto.PaymentResponseModel;
import co.com.meli.microservice.exception.BusinessException;
import co.com.meli.microservice.exception.EntityNotFoundException;
import co.com.meli.microservice.exception.NoDataFoundException;

/**
 * @author juan.mosquera
 *
 */
public interface IPaymentService {

    public PaymentResponseModel savePayment(PaymentRequestModel requestModel)
            throws EntityNotFoundException, NoDataFoundException,
            BusinessException;

}
