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
 * Repository class annotated with @Repository that implement Data Access Object
 * pattern for TargetConfig entity.
 * 
 * @since 0.0.1
 * @author Juan Felipe Mosquera
 * @see Repository
 * @see TargetConfig
 *
 */
@Repository(value = Constant.REPOSITORY_STRING_TARGET_CONFIG)
public interface ITargetConfigRepository
        extends CrudRepository<TargetConfig, Long> {

    /**
     * Get loan conditions by Target and status ordered by creation date.
     * 
     * @param target
     *            target.
     * @param status
     *            configuration status.
     * @return loan conditions.
     * @see Target
     */
    public Iterable<TargetConfig> findByTargetAndStatusOrderByCreationDateDesc(
            Target target,
            Integer status);

}
