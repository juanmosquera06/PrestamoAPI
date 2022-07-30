/**
 * 
 */
package co.com.meli.microservice.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.meli.microservice.persistence.data.Loan;
import co.com.meli.microservice.persistence.data.Payment;

/**
 * @author juan.mosquera
 *
 */
@Repository(value = "paymentRepository")
public interface IPaymentRepository extends CrudRepository<Payment, Long> {

    List<Payment> findAllByLoan(Loan loan);

    List<Payment> findAllByLoanAndCreationDateBetween(Loan loan,
            Date creationDateStart, Date creationDateEnd);

}
