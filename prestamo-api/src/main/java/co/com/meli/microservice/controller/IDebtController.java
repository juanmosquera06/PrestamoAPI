/**
 * 
 */
package co.com.meli.microservice.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import co.com.meli.microservice.enums.Target;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author juan.mosquera
 *
 */
@Tag(name = "Debt", description = "Obtain the pending debt of loans")
public interface IDebtController {

    @Operation(summary = "Get debt of loan", description = "Returns pending balance of loan until a specified date", responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation") })
    @GetMapping(path = "/{loanId}", params = {
            "date" }, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getDebtByLoan(
            @PathVariable("loanId") Long loanId,
            @RequestParam(required = false, name = "date") String date);

    @Operation(summary = "Get total debt of loans", description = "Returns pending balance of loans until a specified date or target", responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation") })
    @GetMapping(params = { "date",
            "target" }, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getTotalDebt(
            @RequestParam(required = false, name = "date") String date,
            @RequestParam(required = false, name = "target") Target target);
}
