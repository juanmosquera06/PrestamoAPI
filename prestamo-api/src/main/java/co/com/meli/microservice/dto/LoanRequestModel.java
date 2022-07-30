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
public class LoanRequestModel {

    @JsonProperty(value = "amount")
    private Double amount;

    @JsonProperty(value = "term")
    private Integer term;

    @JsonProperty(value = "user_id")
    private Long userId;

}
