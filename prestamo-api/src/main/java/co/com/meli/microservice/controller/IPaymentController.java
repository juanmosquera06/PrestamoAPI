/**
 * 
 */
package co.com.meli.microservice.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author juan.mosquera
 *
 */
@Tag(name = "Payment", description = "Record a loan payment")
public interface IPaymentController {

    @Operation(summary = "Record a payment", description = "Apply a loan payment", responses = {
            @ApiResponse(responseCode = "201", description = "Payment applied") })
    @PostMapping(path = "/{loanId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> recordLoanPayment(
            @PathVariable("loanId") Long loanId, @RequestBody Object payment);
}
