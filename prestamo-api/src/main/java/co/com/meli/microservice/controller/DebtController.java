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
import co.com.meli.microservice.service.ILoanService;
import lombok.AllArgsConstructor;

/**
 * @author juan.mosquera
 *
 */
@RestController
@RequestMapping(path = "/api/debts", produces = {
        MediaType.APPLICATION_JSON_VALUE })
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class DebtController implements IDebtController {

    private ILoanService loanService;

    @Override
    public ResponseEntity<DebtResponseModel> getDebtByLoan(Long loanId,
            Optional<String> date) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(loanService.getDebtByIdLoanAndDateFilter(loanId, date));
    }

    @Override
    public ResponseEntity<Object> getTotalDebt(String date, Target target) {
        // TODO Auto-generated method stub
        return null;
    }

}
