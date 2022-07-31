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
public class InstallmentResponseModel {

    @JsonProperty(value = Constant.COMMON_STRING_JSONPROPERTY_LOAN_ID)
    private Long id;

    @JsonProperty(value = Constant.COMMON_STRING_JSONPROPERTY_INSTALLMENT)
    private Double installment;
}
