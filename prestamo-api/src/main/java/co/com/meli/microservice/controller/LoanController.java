/**
 * 
 */
package co.com.meli.microservice.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.meli.microservice.dto.LoanDto;
import co.com.meli.microservice.service.ILoanService;
import lombok.AllArgsConstructor;

/**
 * @author juan.mosquera
 *
 */
@RestController
@RequestMapping(path = "/api/loans", produces = {
        MediaType.APPLICATION_JSON_VALUE })
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class LoanController implements ILoanController {

    private ILoanService loanService;

    @Override
    public ResponseEntity<Object> createLoan(LoanDto loan) {
        loanService.saveLoan(loan);
        return null;
    }

    @Override
    public ResponseEntity<Object> getLoansByDateRange(String dateFrom,
            String dateTo) {
        // TODO Auto-generated method stub
        return null;
    }

}
