/**
 * 
 */
package co.com.meli.microservice.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.meli.microservice.persistence.data.Loan;
import co.com.meli.microservice.util.Constant;

/**
 * @author juan.mosquera
 *
 */
@Repository(value = Constant.REPOSITORY_STRING_LOAN)
public interface ILoanRepository extends CrudRepository<Loan, Long> {

    List<Loan> findAllByCreationDateBetween(LocalDateTime creationDateStart,
            LocalDateTime creationDateEnd);

}
