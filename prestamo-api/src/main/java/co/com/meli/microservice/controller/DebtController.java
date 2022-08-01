/**
 * 
 */
package co.com.meli.microservice.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.meli.microservice.dto.DebtResponseModel;
import co.com.meli.microservice.enums.Target;
import co.com.meli.microservice.exception.BusinessException;
import co.com.meli.microservice.exception.DateException;
import co.com.meli.microservice.exception.EntityNotFoundException;
import co.com.meli.microservice.exception.NoDataFoundException;
import co.com.meli.microservice.service.ILoanService;
import co.com.meli.microservice.util.Constant;
import lombok.AllArgsConstructor;

/**
 * Controller that is responsible for handling the different HTTP requests about
 * debts.
 * </p>
 * 
 * Each request handling method of the class automatically serializes the
 * objects returned in the HTTP response.
 * </p>
 * 
 * Implement IDebtController interface.
 * 
 * @since 0.0.1
 * @author Juan Felipe Mosquera
 * @see IDebtController
 *
 */
@RestController
@RequestMapping(path = Constant.SERVICE_STRING_DEBTS_PATH, produces = {
        MediaType.APPLICATION_JSON_VALUE })
@AllArgsConstructor
@CrossOrigin(origins = Constant.COMMON_STRING_ASTERIC)
public class DebtController implements IDebtController {

    private ILoanService loanService;

    @Override
    public ResponseEntity<DebtResponseModel> getDebtByLoan(Long loanId,
            Optional<String> date)
            throws EntityNotFoundException, NoDataFoundException,
            BusinessException, DateException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(loanService.getDebtByIdLoanAndDateFilter(loanId, date));
    }

    @Override
    public ResponseEntity<DebtResponseModel> getTotalDebt(Optional<String> date,
            Optional<Target> target) throws BusinessException, DateException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(loanService.getDebtByTargetAndDateFilter(date, target));
    }

}
