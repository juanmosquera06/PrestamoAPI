/**
 * 
 */
package co.com.meli.microservice.service;

import java.util.Map;

import co.com.meli.microservice.exception.EntityNotFoundException;
import co.com.meli.microservice.exception.NoDataFoundException;
import co.com.meli.microservice.persistence.data.Client;

/**
 * Client related business logic interface.
 * 
 * @since 0.0.1
 * @author Juan Felipe Mosquera
 *
 */
public interface IClientService {

    /**
     * Get a Client entity by its identifier attribute.
     * 
     * @param id
     *            client identifier.
     * @return client entity.
     * @throws EntityNotFoundException
     *             if client not exists.
     * @see Client
     */
    public Client findById(Long id) throws EntityNotFoundException;

    /**
     * Get loan conditions by client.
     * 
     * @param client
     *            entity.
     * @return key-value pair with loan conditions.
     * @throws NoDataFoundException
     *             if loan conditions are not found.
     */
    public Map<String, Double> findActiveLoanConditionsByClient(Client client)
            throws NoDataFoundException;

}
