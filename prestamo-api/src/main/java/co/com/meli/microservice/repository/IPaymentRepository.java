/**
 * 
 */
package co.com.meli.microservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.meli.microservice.persistence.data.Loan;
import co.com.meli.microservice.persistence.data.Payment;
import co.com.meli.microservice.util.Constant;

/**
 * Repository class annotated with @Repository that implement Data Access Object
 * pattern for Payment entity.
 * 
 * @since 0.0.1
 * @author Juan Felipe Mosquera
 * @see Repository
 * @see Payment
 *
 */
@Repository(value = Constant.REPOSITORY_STRING_PAYMENT)
public interface IPaymentRepository extends CrudRepository<Payment, Long> {

    /**
     * Get all payments applied to a loan.
     * 
     * @param loan
     *            loan to consult
     * @return a list of payments.
     */
    public List<Payment> findAllByLoan(Loan loan);

}
