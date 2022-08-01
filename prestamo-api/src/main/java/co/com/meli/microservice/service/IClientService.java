/**
 * 
 */
package co.com.meli.microservice.service;

import java.util.Map;

import co.com.meli.microservice.exception.EntityNotFoundException;
import co.com.meli.microservice.exception.NoDataFoundException;
import co.com.meli.microservice.persistence.data.Client;

/**
 * @author juan.mosquera
 *
 */
public interface IClientService {

    public Client findById(Long id) throws EntityNotFoundException;

    public Map<String, Double> findActiveLoanConditionsByClient(Client client)
            throws NoDataFoundException;

}
