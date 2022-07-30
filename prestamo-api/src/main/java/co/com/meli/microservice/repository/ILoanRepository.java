/**
 * 
 */
package co.com.meli.microservice.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.meli.microservice.persistence.data.Loan;

/**
 * @author juan.mosquera
 *
 */
@Repository(value = "loanRepository")
public interface ILoanRepository extends CrudRepository<Loan, Long> {

    List<Loan> findAllByCreationDateBetween(Date creationDateStart,
            Date creationDateEnd);

}
