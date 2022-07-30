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
import co.com.meli.microservice.service.IPaymentService;
import lombok.AllArgsConstructor;

/**
 * @author juan.mosquera
 *
 */
@RestController
@RequestMapping(path = "/api/payments", produces = {
        MediaType.APPLICATION_JSON_VALUE })
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class PaymentController implements IPaymentController {

    private IPaymentService paymentService;

    @Override
    public ResponseEntity<PaymentResponseModel> recordLoanPayment(Long loanId,
            PaymentRequestModel payment) {
        if (null == payment) {
            return null;
            // Not implemented yet
        }

        payment.setLoanId(loanId);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(paymentService.savePayment(payment));
    }

}
