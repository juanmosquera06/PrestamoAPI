/**
 * 
 */
package co.com.meli.microservice.util;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import co.com.meli.microservice.dto.LoanDto;
import co.com.meli.microservice.persistence.data.Loan;

/**
 * @author juan.mosquera
 *
 */
@Component
@Mapper(componentModel = "spring")
public interface MapperUtil {

    Loan loanDtoToLoan(LoanDto loanDto);
}
