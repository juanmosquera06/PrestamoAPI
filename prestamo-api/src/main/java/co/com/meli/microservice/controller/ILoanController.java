/**
 * 
 */
package co.com.meli.microservice.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author juan.mosquera
 *
 */
@Tag(name = "Loan", description = "Create a loan request and get the list of loans")
public interface ILoanController {

    @Operation(summary = "Create a loan", description = "Create a loan request", responses = {
            @ApiResponse(responseCode = "201", description = "Loan created") })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createLoan(@RequestBody Object loan);

    @Operation(summary = "Get all loans by date range", description = "Returns all loans with date range filter", responses = {
            @ApiResponse(responseCode = "200", description = "Successful operation") })
    @GetMapping(params = { "dateFrom", "dateTo" })
    public ResponseEntity<Object> getLoansByDateRange(
            @RequestParam(required = true, name = "dateFrom") String dateFrom,
            @RequestParam(required = true, name = "dateTo") String dateTo);
}
