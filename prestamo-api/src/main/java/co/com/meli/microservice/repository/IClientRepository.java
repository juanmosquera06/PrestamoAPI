/**
 * 
 */
package co.com.meli.microservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.meli.microservice.persistence.data.Client;
import co.com.meli.microservice.util.Constant;

/**
 * Repository class annotated with @Repository that implement Data Access Object
 * pattern for Client entity.
 * 
 * @since 0.0.1
 * @author Juan Felipe Mosquera
 * @see Repository
 * @see Client
 *
 */
@Repository(value = Constant.REPOSITORY_STRING_CLIENT)
public interface IClientRepository extends CrudRepository<Client, Long> {

}
