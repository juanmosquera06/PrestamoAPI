/**
 * 
 */
package co.com.meli.microservice.service.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;

import co.com.meli.microservice.controller.DebtController;
import co.com.meli.microservice.dto.DebtResponseModel;
import co.com.meli.microservice.service.ILoanService;

/**
 * Unit tests of the DebtController class.
 * 
 * @author Juan Felipe Mosquera
 *
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class DebtControllerTest {

    @InjectMocks
    private DebtController debtController;

    @Mock
    private ILoanService loanService;

    private Double debt;
    private DebtResponseModel response;

    @BeforeEach
    public void setUp() {
        debt = 90D;

        response = new DebtResponseModel();
        response.setDebt(debt);
    }

    @Test
    void getLoanDebtByIdLoanTest() {
        ResponseEntity<DebtResponseModel> response = null;

        when(loanService.getDebtByIdLoanAndDateFilter(any(), any()))
                .thenReturn(this.response);
        response = debtController.getDebtByLoan(1L, Optional.empty());

        assertEquals(this.response, response.getBody());
    }

    @Test
    void getTotalDebtTest() {
        ResponseEntity<DebtResponseModel> response = null;

        when(loanService.getDebtByTargetAndDateFilter(any(), any()))
                .thenReturn(this.response);
        response = debtController.getTotalDebt(Optional.empty(),
                Optional.empty());

        assertEquals(this.response, response.getBody());
    }
}
