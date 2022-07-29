/**
 * 
 */
package co.com.meli.microservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author juan.mosquera
 *
 */
@Data
public class LoanDto {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "amount")
    private Double amount;

    @JsonProperty(value = "term")
    private Integer term;

    @JsonProperty(value = "rate")
    private Double rate;

    @JsonProperty(value = "user_id")
    private Long userId;

}
