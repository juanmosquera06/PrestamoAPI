/**
 * 
 */
package co.com.meli.microservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.meli.microservice.persistence.data.Target;
import co.com.meli.microservice.persistence.data.TargetConfig;

/**
 * @author juan.mosquera
 *
 */
@Repository(value = "targetConfigRepository")
public interface ITargetConfigRepository
        extends CrudRepository<TargetConfig, Long> {

    public Iterable<TargetConfig> findByTargetAndStatusOrderByCreationDateDesc(
            Target target,
            Integer status);

}
