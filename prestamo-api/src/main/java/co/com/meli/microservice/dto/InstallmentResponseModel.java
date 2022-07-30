/**
 * 
 */
package co.com.meli.microservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

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

    @JsonProperty(value = "loan_id")
    private Long id;

    @JsonProperty(value = "installment")
    private Double installment;
}
