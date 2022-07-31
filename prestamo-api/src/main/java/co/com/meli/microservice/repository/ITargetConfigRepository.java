/**
 * 
 */
package co.com.meli.microservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.meli.microservice.persistence.data.Target;
import co.com.meli.microservice.persistence.data.TargetConfig;
import co.com.meli.microservice.util.Constant;

/**
 * @author juan.mosquera
 *
 */
@Repository(value = Constant.REPOSITORY_STRING_TARGET_CONFIG)
public interface ITargetConfigRepository
        extends CrudRepository<TargetConfig, Long> {

    public Iterable<TargetConfig> findByTargetAndStatusOrderByCreationDateDesc(
            Target target,
            Integer status);

}
