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
 * Repository class annotated with @Repository that implement Data Access Object
 * pattern for Loan entity.
 * 
 * @since 0.0.1
 * @author Juan Felipe Mosquera
 * @see Repository
 * @see Loan
 *
 */
@Repository(value = Constant.REPOSITORY_STRING_LOAN)
public interface ILoanRepository extends CrudRepository<Loan, Long> {

    /**
     * Get all loans with a date range criteria.
     * 
     * @param creationDateStart
     *            creation date start.
     * @param creationDateEnd
     *            creation date end.
     * @return a list of loans.
     */
    public List<Loan> findAllByCreationDateBetween(
            LocalDateTime creationDateStart,
            LocalDateTime creationDateEnd);

}
