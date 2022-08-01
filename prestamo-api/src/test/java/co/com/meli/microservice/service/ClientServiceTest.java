/**
 * 
 */
package co.com.meli.microservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import co.com.meli.microservice.exception.EntityNotFoundException;
import co.com.meli.microservice.exception.NoDataFoundException;
import co.com.meli.microservice.persistence.data.Client;
import co.com.meli.microservice.persistence.data.TargetConfig;
import co.com.meli.microservice.repository.IClientRepository;
import co.com.meli.microservice.repository.ITargetConfigRepository;
import co.com.meli.microservice.util.Constant;

/**
 * Unit tests of the ClientService class.
 * 
 * @author Juan Felipe Mosquera
 *
 */
@SpringBootTest
class ClientServiceTest {

    @InjectMocks
    private ClientService clientService;

    @Mock
    private IClientRepository clientRepository;

    @Mock
    private ITargetConfigRepository targetConfigRepository;

    private Client client;
    private TargetConfig targetConfig;
    private Map<String, Double> loanConditions;

    @BeforeEach
    public void setUp() {
        client = new Client();
        client.setId(1L);

        targetConfig = new TargetConfig();
        targetConfig.setId(1L);
        targetConfig.setDescription(Constant.LOAN_CONDITION_STRING_RATE);
        targetConfig.setValue(0D);

        loanConditions = new HashMap<>();
        loanConditions.put(Constant.LOAN_CONDITION_STRING_RATE, 0D);
    }

    @Test
    void findClientByIdTest() throws EntityNotFoundException {
        Client client = null;

        when(clientRepository.findById(anyLong()))
                .thenReturn(Optional.of(this.client));
        client = clientService.findById(1L);

        assertEquals(this.client, client);
    }

    @Test()
    void findClientByIdTestWhenClientIsNotPresent() {
        when(clientRepository.findById(anyLong()))
                .thenThrow(new EntityNotFoundException(String.format(
                        Constant.ERROR_STRING_ENTITY_NOT_FOUND,
                        Client.class.getSimpleName(), this.client.getId())));

        assertThrows(EntityNotFoundException.class,
                () -> clientService.findById(1L));
    }

    @Test
    void findLoanConditionsByClientTest() {
        Map<String, Double> loanConditions = null;

        List<TargetConfig> targetConfigs = new ArrayList<>();
        targetConfigs.add(targetConfig);
        
        when(targetConfigRepository
                .findByTargetAndStatusOrderByCreationDateDesc(any(),
                        anyInt())).thenReturn(targetConfigs);

        loanConditions = clientService
                .findActiveLoanConditionsByClient(this.client);

        assertEquals(this.loanConditions, loanConditions);
    }

    @Test
    void findLoanConditionsByClientTestWhenConditionsNotFound() {
        when(targetConfigRepository
                .findByTargetAndStatusOrderByCreationDateDesc(any(), anyInt()))
                        .thenReturn(null);

        assertThrows(NoDataFoundException.class, () -> clientService
                .findActiveLoanConditionsByClient(this.client));
    }
}
