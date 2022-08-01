/**
 * 
 */
package co.com.meli.microservice.service.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;

import co.com.meli.microservice.controller.LoanController;
import co.com.meli.microservice.dto.InstallmentResponseModel;
import co.com.meli.microservice.dto.LoanRequestModel;
import co.com.meli.microservice.dto.LoanResponseModel;
import co.com.meli.microservice.service.ILoanService;

/**
 * @author juan.mosquera
 *
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class LoanControllerTest {

    @InjectMocks
    private LoanController loanController;

    @Mock
    private ILoanService loanService;

    private final String STRING_DATE_FROM = "2022-07-30";
    private final String STRING_DATE_TO = "2022-07-31";
    private InstallmentResponseModel installmentResponse;
    private LoanResponseModel loanResponse;
    private List<LoanResponseModel> loanResponses;
    private LoanRequestModel loanRequest;

    @BeforeEach
    public void setUp() {
        installmentResponse = new InstallmentResponseModel();
        installmentResponse.setId(1L);
        installmentResponse.setInstallment(100D);

        loanResponse = new LoanResponseModel();
        loanResponse.setId(1L);
        loanResponse.setAmount(100D);
        loanResponse.setTerm(1);
        loanResponse.setRate(0.1D);

        loanRequest = new LoanRequestModel();
        loanRequest.setAmount(100D);
        loanRequest.setTerm(1);
        loanRequest.setUserId(1L);

        loanResponses = new ArrayList<>();
        loanResponses.add(loanResponse);
    }

    @Test
    void createLoanTest() {
        ResponseEntity<InstallmentResponseModel> response = null;

        when(loanService.saveLoan(any())).thenReturn(this.installmentResponse);
        response = loanController.createLoan(loanRequest);

        assertEquals(this.installmentResponse, response.getBody());
    }

    @Test
    void getLoansByDateRangeTest() {
        ResponseEntity<List<LoanResponseModel>> response = null;

        when(loanService.findAllLoansByDateRange(any(), any()))
                .thenReturn(this.loanResponses);
        response = loanController.getLoansByDateRange(STRING_DATE_FROM,
                STRING_DATE_TO);

        assertEquals(this.loanResponses, response.getBody());
    }

}
