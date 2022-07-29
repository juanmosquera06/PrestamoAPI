/**
 * 
 */
package co.com.meli.microservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.meli.microservice.persistence.data.Loan;

/**
 * @author juan.mosquera
 *
 */
@Repository(value = "loanRepository")
public interface ILoanRepository extends CrudRepository<Loan, Long> {

}
