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
@Mapper(componentModel = Constant.MAPPER_STRING_COMPONENT_MODEL)
public interface MapperUtil {

    Loan loanRequestModelToLoan(LoanRequestModel requestModel);

    InstallmentResponseModel loanToInstallmentResponseModel(Loan loan);

    @Mapping(source = Constant.MAPPER_STRING_CLIENT_DOT_ID, target = Constant.MAPPER_STRING_USER_ID)
    @Mapping(source = Constant.MAPPER_STRING_CREATION_DATE, target = Constant.MAPPER_STRING_DATE)
    @Mapping(source = Constant.MAPPER_STRING_CLIENT_DOT_TARGET_DOT_DESCRIPTION, target = Constant.MAPPER_STRING_TARGET)
    LoanResponseModel loanToLoanResponseModel(Loan loan);

    List<LoanResponseModel> loanToLoanResponseModels(List<Loan> loans);

    Payment paymentRequestModelToPayment(PaymentRequestModel requestModel);

    @Mapping(source = Constant.MAPPER_STRING_LOAN_DOT_ID, target = Constant.MAPPER_STRING_LOAN_ID)
    PaymentResponseModel paymenToPaymentResponseModel(Payment payment);

}
