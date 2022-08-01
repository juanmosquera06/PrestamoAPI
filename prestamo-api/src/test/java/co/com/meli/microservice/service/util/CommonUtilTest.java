/**
 * 
 */
package co.com.meli.microservice.service.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import co.com.meli.microservice.util.CommonUtil;

/**
 * @author juan.mosquera
 *
 */
@SpringBootTest
class CommonUtilTest {

    @Test
    void calculateMonthlyRateTest() {
        Double rate = CommonUtil.calculateMonthlyRate(12D);
        
        assertThat(rate).isEqualTo(1D);
    }

    @Test
    void calculateLoanInstallmentTest() {
        Double installment = CommonUtil.calculateLoanInstallment(0.15D, 12,
                1000D);

        assertThat(installment).isEqualTo(184.48077613083956D);
    }
}
