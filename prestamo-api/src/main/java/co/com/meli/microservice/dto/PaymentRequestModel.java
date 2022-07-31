/**
 * 
 */
package co.com.meli.microservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import co.com.meli.microservice.util.Constant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author juan.mosquera
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequestModel {

    @JsonProperty(value = Constant.COMMON_STRING_JSONPROPERTY_LOAN_ID)
    private Long loanId;

    @JsonProperty(value = Constant.COMMON_STRING_JSONPROPERTY_AMOUNT)
    private Double amount;

}
