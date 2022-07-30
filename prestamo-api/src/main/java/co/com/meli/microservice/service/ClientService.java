/**
 * 
 */
package co.com.meli.microservice.service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import co.com.meli.microservice.persistence.data.Client;
import co.com.meli.microservice.persistence.data.TargetConfig;
import co.com.meli.microservice.repository.IClientRepository;
import co.com.meli.microservice.repository.ITargetConfigRepository;
import co.com.meli.microservice.util.Constant;
import lombok.AllArgsConstructor;

/**
 * @author juan.mosquera
 *
 */
@Service(value = "clientService")
@AllArgsConstructor
public class ClientService implements IClientService {

    private IClientRepository clientRepository;
    private ITargetConfigRepository targetConfigRepository;
    
    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public Map<String, Double> findActiveLoanConditionsByClient(Client client) {
        Map<String, Double> loanConditions = new HashMap<>();

        Iterable<TargetConfig> targetConfigs = targetConfigRepository
                .findByTargetAndStatusOrderByCreationDateDesc(
                        client.getTarget(),
                Constant.COMMON_INTEGER_ACTIVE_STATUS);

        // TODO NullPointer validation
        loanConditions.put(Constant.LOAN_CONDITION_STRING_RATE, StreamSupport
                .stream(targetConfigs.spliterator(), false)
                .filter(targetConfig -> Constant.LOAN_CONDITION_STRING_RATE
                        .equalsIgnoreCase(targetConfig.getDescription()))
                .findFirst().orElse(null).getValue());

        return loanConditions;
    }

}
