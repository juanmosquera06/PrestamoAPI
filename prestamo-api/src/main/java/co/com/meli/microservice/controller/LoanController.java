/**
 * 
 */
package co.com.meli.microservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.meli.microservice.dto.InstallmentResponseModel;
import co.com.meli.microservice.dto.LoanRequestModel;
import co.com.meli.microservice.dto.LoanResponseModel;
import co.com.meli.microservice.exception.BusinessException;
import co.com.meli.microservice.exception.DateException;
import co.com.meli.microservice.exception.EntityNotFoundException;
import co.com.meli.microservice.exception.NoDataFoundException;
import co.com.meli.microservice.service.ILoanService;
import co.com.meli.microservice.util.Constant;
import lombok.AllArgsConstructor;

/**
 * Controller that is responsible for handling the different HTTP requests about
 * loans.
 * <p>
 * 
 * Each request handling method of the class automatically serializes the
 * objects returned in the HTTP response.
 * <p>
 * 
 * Implement ILoanController interface.
 * 
 * @since 0.0.1
 * @author Juan Felipe Mosquera
 * @see ILoanController
 *
 */
@RestController
@RequestMapping(path = Constant.SERVICE_STRING_LOANS_PATH, produces = {
        MediaType.APPLICATION_JSON_VALUE })
@AllArgsConstructor
@CrossOrigin(origins = Constant.COMMON_STRING_ASTERIC)
public class LoanController implements ILoanController {

    private ILoanService loanService;

    @Override
    public ResponseEntity<InstallmentResponseModel> createLoan(
            LoanRequestModel loan)
            throws EntityNotFoundException, NoDataFoundException,
            BusinessException {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(loanService.saveLoan(loan));
    }

    @Override
    public ResponseEntity<List<LoanResponseModel>> getLoansByDateRange(
            String dateFrom,
            String dateTo) throws NoDataFoundException, DateException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(loanService.findAllLoansByDateRange(dateFrom, dateTo));
    }

}
