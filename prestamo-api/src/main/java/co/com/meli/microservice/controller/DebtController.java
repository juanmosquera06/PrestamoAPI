/**
 * 
 */
package co.com.meli.microservice.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.meli.microservice.enums.Target;
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

    @Override
    public ResponseEntity<Object> getDebtByLoan(Long loanId, String date) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<Object> getTotalDebt(String date, Target target) {
        // TODO Auto-generated method stub
        return null;
    }

}
