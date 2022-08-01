/**
 * 
 */
package co.com.meli.microservice.service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import co.com.meli.microservice.exception.EntityNotFoundException;
import co.com.meli.microservice.exception.NoDataFoundException;
import co.com.meli.microservice.persistence.data.Client;
import co.com.meli.microservice.persistence.data.TargetConfig;
import co.com.meli.microservice.repository.IClientRepository;
import co.com.meli.microservice.repository.ITargetConfigRepository;
import co.com.meli.microservice.util.Constant;
import lombok.AllArgsConstructor;

/**
 * Business logic that implements IClientService interface. It contains the
 * business logic that allows getting client information and parameterized loan
 * conditions.
 * 
 * @since 0.0.1
 * @author Juan Felipe Mosquera
 * @see IClientService
 *
 */
@Service(value = Constant.SERVICE_STRING_CLIENT)
@AllArgsConstructor
public class ClientService implements IClientService {

    private IClientRepository clientRepository;
    private ITargetConfigRepository targetConfigRepository;
    
    @Override
    public Client findById(Long id) throws EntityNotFoundException {
        return clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String
                        .format(Constant.ERROR_STRING_ENTITY_NOT_FOUND,
                                Client.class.getSimpleName(), id)));
    }

    @Override
    public Map<String, Double> findActiveLoanConditionsByClient(Client client)
            throws NoDataFoundException {
        Map<String, Double> loanConditions = new HashMap<>();

        Iterable<TargetConfig> targetConfigs = targetConfigRepository
                .findByTargetAndStatusOrderByCreationDateDesc(
                        client.getTarget(),
                Constant.COMMON_INTEGER_ACTIVE_STATUS);
        if (null == targetConfigs || !targetConfigs.iterator().hasNext()) {
            throw new NoDataFoundException(
                    String.format(Constant.ERROR_STRING_NOT_DATA_FOUND,
                            Client.class.getSimpleName()));
        }

        loanConditions.put(Constant.LOAN_CONDITION_STRING_RATE, StreamSupport
                .stream(targetConfigs.spliterator(), false)
                .filter(targetConfig -> Constant.LOAN_CONDITION_STRING_RATE
                        .equalsIgnoreCase(targetConfig.getDescription()))
                .findFirst()
                .orElseThrow(() -> new NoDataFoundException(
                        String.format(Constant.ERROR_STRING_ENTITY_NOT_FOUND,
                                TargetConfig.class.getSimpleName())))
                .getValue());

        return loanConditions;
    }

}
