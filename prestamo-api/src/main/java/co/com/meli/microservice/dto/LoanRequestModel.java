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
public class LoanRequestModel {

    @JsonProperty(value = Constant.COMMON_STRING_JSONPROPERTY_AMOUNT)
    private Double amount;

    @JsonProperty(value = Constant.COMMON_STRING_JSONPROPERTY_TERM)
    private Integer term;

    @JsonProperty(value = Constant.COMMON_STRING_JSONPROPERTY_USER_ID)
    private Long userId;

}
