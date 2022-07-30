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
public class PaymentResponseModel {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "loan_id")
    private Long loanId;

    @JsonProperty(value = "debt")
    private Double debt;

}
