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
 * Payment related business logic interface.
 * 
 * @since 0.0.1
 * @author Juan Felipe Mosquera
 *
 */
public interface IPaymentService {

    /**
     * Record a payment.
     * 
     * @param requestModel
     *            DTO with payment information.
     * @return DTO with payment information .
     * @throws EntityNotFoundException
     *             if loan does not exist.
     * @throws NoDataFoundException
     *             if there is an error getting the previous payments.
     * @throws BusinessException
     *             if any entered value is invalid.
     */
    public PaymentResponseModel savePayment(PaymentRequestModel requestModel)
            throws EntityNotFoundException, NoDataFoundException,
            BusinessException;

}
