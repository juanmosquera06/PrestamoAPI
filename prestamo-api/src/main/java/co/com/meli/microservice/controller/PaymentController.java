/**
 * 
 */
package co.com.meli.microservice.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Override
    public ResponseEntity<Object> recordLoanPayment(Long loanId,
            Object payment) {
        // TODO Auto-generated method stub
        return null;
    }

}
