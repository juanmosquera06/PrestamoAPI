/**
 * 
 */
package co.com.meli.microservice.service.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;

import co.com.meli.microservice.controller.PaymentController;
import co.com.meli.microservice.dto.PaymentRequestModel;
import co.com.meli.microservice.dto.PaymentResponseModel;
import co.com.meli.microservice.service.IPaymentService;

/**
 * @author juan.mosquera
 *
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PaymentControllerTest {

    @InjectMocks
    private PaymentController paymentController;

    @Mock
    private IPaymentService paymentService;

    private PaymentRequestModel request;
    private PaymentResponseModel response;

    @BeforeEach
    public void setUp() {
        request = new PaymentRequestModel();
        request.setLoanId(1L);
        request.setAmount(100D);

        response = new PaymentResponseModel();
        response.setId(1L);
        response.setDebt(100D);
        response.setLoanId(1L);
    }

    @Test
    void recordLoanPayment() {
        ResponseEntity<PaymentResponseModel> response = null;

        when(paymentService.savePayment(any())).thenReturn(this.response);
        response = paymentController.recordLoanPayment(1L, request);

        assertEquals(this.response, response.getBody());
    }

}
