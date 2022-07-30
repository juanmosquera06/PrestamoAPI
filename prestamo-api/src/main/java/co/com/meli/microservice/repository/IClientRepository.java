/**
 * 
 */
package co.com.meli.microservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.meli.microservice.persistence.data.Client;

/**
 * @author juan.mosquera
 *
 */
@Repository(value = "clientRepository")
public interface IClientRepository extends CrudRepository<Client, Long> {

}
