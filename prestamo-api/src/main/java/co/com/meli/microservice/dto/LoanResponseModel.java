/**
 * 
 */
package co.com.meli.microservice.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import co.com.meli.microservice.util.Constant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO that contains the information of the response of the loan model.
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
public class LoanResponseModel {

    @JsonProperty(value = Constant.COMMON_STRING_JSONPROPERTY_ID)
    private Long id;

    @JsonProperty(value = Constant.COMMON_STRING_JSONPROPERTY_AMOUNT)
    private Double amount;

    @JsonProperty(value = Constant.COMMON_STRING_JSONPROPERTY_TERM)
    private Integer term;

    @JsonProperty(value = Constant.COMMON_STRING_JSONPROPERTY_RATE)
    private Double rate;

    @JsonProperty(value = Constant.COMMON_STRING_JSONPROPERTY_USER_ID)
    private Long userId;

    @JsonProperty(value = Constant.COMMON_STRING_JSONPROPERTY_TARGET)
    private co.com.meli.microservice.enums.Target target;

    @JsonProperty(value = Constant.COMMON_STRING_JSONPROPERTY_DATE)
    private LocalDateTime date;

}
