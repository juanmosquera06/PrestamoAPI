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
 * @author juan.mosquera
 *
 */
@Repository(value = Constant.REPOSITORY_STRING_PAYMENT)
public interface IPaymentRepository extends CrudRepository<Payment, Long> {

    List<Payment> findAllByLoan(Loan loan);

}
