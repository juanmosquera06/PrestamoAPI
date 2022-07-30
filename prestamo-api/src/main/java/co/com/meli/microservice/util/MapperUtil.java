/**
 * 
 */
package co.com.meli.microservice.util;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import co.com.meli.microservice.dto.InstallmentResponseModel;
import co.com.meli.microservice.dto.LoanRequestModel;
import co.com.meli.microservice.dto.LoanResponseModel;
import co.com.meli.microservice.dto.PaymentRequestModel;
import co.com.meli.microservice.dto.PaymentResponseModel;
import co.com.meli.microservice.persistence.data.Loan;
import co.com.meli.microservice.persistence.data.Payment;

/**
 * @author juan.mosquera
 *
 */
@Component
@Mapper(componentModel = "spring")
public interface MapperUtil {

    Loan loanRequestModelToLoan(LoanRequestModel requestModel);

    InstallmentResponseModel loanToInstallmentResponseModel(Loan loan);

    @Mapping(source = "client.id", target = "userId")
    @Mapping(source = "creationDate", target = "date")
    @Mapping(source = "client.target.description", target = "target")
    LoanResponseModel loanToLoanResponseModel(Loan loan);

    List<LoanResponseModel> loanToLoanResponseModels(List<Loan> loans);

    Payment paymentRequestModelToPayment(PaymentRequestModel requestModel);

    @Mapping(source = "loan.id", target = "loanId")
    PaymentResponseModel paymenToPaymentResponseModel(Payment payment);

}
