/**
 * 
 */
package co.com.meli.microservice.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class LoanResponseModel {

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

    @JsonProperty(value = "target")
    private co.com.meli.microservice.enums.Target target;

    @JsonProperty(value = "date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mmZ")
    private Date date;

}
