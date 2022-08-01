/**
 * 
 */
package co.com.meli.microservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.meli.microservice.dto.PaymentRequestModel;
import co.com.meli.microservice.dto.PaymentResponseModel;
import co.com.meli.microservice.exception.BusinessException;
import co.com.meli.microservice.exception.EntityNotFoundException;
import co.com.meli.microservice.exception.NoDataFoundException;
import co.com.meli.microservice.service.IPaymentService;
import co.com.meli.microservice.util.Constant;
import lombok.AllArgsConstructor;

/**
 * Controller that is responsible for handling the different HTTP requests about
 * payments.
 * </p>
 * 
 * Each request handling method of the class automatically serializes the
 * objects returned in the HTTP response.
 * </p>
 * 
 * Implement IPaymentController interface.
 * 
 * @since 0.0.1
 * @author Juan Felipe Mosquera
 * @see IPaymentController
 *
 */
@RestController
@RequestMapping(path = Constant.SERVICE_STRING_PAYMENTS_PATH, produces = {
        MediaType.APPLICATION_JSON_VALUE })
@AllArgsConstructor
@CrossOrigin(origins = Constant.COMMON_STRING_ASTERIC)
public class PaymentController implements IPaymentController {

    private IPaymentService paymentService;

    @Override
    public ResponseEntity<PaymentResponseModel> recordLoanPayment(Long loanId,
            PaymentRequestModel payment)
            throws EntityNotFoundException, NoDataFoundException,
            BusinessException {
        payment.setLoanId(loanId);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(paymentService.savePayment(payment));
    }

}
