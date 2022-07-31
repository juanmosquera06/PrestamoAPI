/**
 * 
 */
package co.com.meli.microservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.meli.microservice.persistence.data.Client;
import co.com.meli.microservice.util.Constant;

/**
 * @author juan.mosquera
 *
 */
@Repository(value = Constant.REPOSITORY_STRING_CLIENT)
public interface IClientRepository extends CrudRepository<Client, Long> {

}
