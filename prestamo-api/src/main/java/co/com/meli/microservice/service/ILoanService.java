/**
 * 
 */
package co.com.meli.microservice.service;

import java.util.List;

import co.com.meli.microservice.dto.LoanDto;
import co.com.meli.microservice.persistence.data.Loan;

/**
 * @author juan.mosquera
 *
 */
public interface ILoanService {

    public Loan findById(Long id);

    public List<Loan> findAllLoans();

    public LoanDto saveLoan(LoanDto loan);

}
