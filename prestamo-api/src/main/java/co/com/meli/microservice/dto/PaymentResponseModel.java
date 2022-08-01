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
 * DTO that contains the information of the response of the payment model.
 * <p>
 * 
 * It have annotations JsonProperty that can be used to define an object field
 * to be used (serialized, deserialized) as a logical property.
 * 
 * @since 0.0.1
 * @author Juan Felipe Mosquera
 * @see JsonProperty
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponseModel {

    @JsonProperty(value = Constant.COMMON_STRING_JSONPROPERTY_ID)
    private Long id;

    @JsonProperty(value = Constant.COMMON_STRING_JSONPROPERTY_LOAN_ID)
    private Long loanId;

    @JsonProperty(value = Constant.COMMON_STRING_JSONPROPERTY_DEBT)
    private Double debt;

}
