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
 * Interface to map between different object models (e.g. entities and DTOs).
 * 
 * @since 0.0.1
 * @author Juan Felipe Mosquera
 *
 */
@Component
@Mapper(componentModel = Constant.MAPPER_STRING_COMPONENT_MODEL)
public interface MapperUtil {

    /**
     * Generates a mapper for creating a Loan object out of a LoanRequestModel
     * object.
     * 
     * @param requestModel
     *            DTO that is required to be mapped.
     * @return Loan object mapped.
     * @see LoanRequestModel
     * @see Loan
     */
    Loan loanRequestModelToLoan(LoanRequestModel requestModel);

    /**
     * Generates a mapper for creating a InstallmentResponseModel object out of
     * a Loan object.
     * 
     * @param loan
     *            DTO that is required to be mapped.
     * @return InstallmentResponseModel object mapped.
     * @see Loan
     * @see InstallmentResponseModel
     */
    InstallmentResponseModel loanToInstallmentResponseModel(Loan loan);

    /**
     * Generates a mapper for creating a LoanResponseModel object out of a Loan
     * object.
     * 
     * @param loan
     *            DTO that is required to be mapped.
     * @return LoanResponseModel object mapped.
     * @see Loan
     * @see LoanResponseModel
     */
    @Mapping(source = Constant.MAPPER_STRING_CLIENT_DOT_ID, target = Constant.MAPPER_STRING_USER_ID)
    @Mapping(source = Constant.MAPPER_STRING_CREATION_DATE, target = Constant.MAPPER_STRING_DATE)
    @Mapping(source = Constant.MAPPER_STRING_CLIENT_DOT_TARGET_DOT_DESCRIPTION, target = Constant.MAPPER_STRING_TARGET)
    LoanResponseModel loanToLoanResponseModel(Loan loan);

    /**
     * Generates a mapper for creating a LoanResponseModel list out of a Loan
     * list.
     * 
     * @param loans
     *            list with DTO that is required to be mapped.
     * @return a list mapped.
     * @see Loan
     * @see LoanResponseModel
     */
    List<LoanResponseModel> loanToLoanResponseModels(List<Loan> loans);

    /**
     * Generates a mapper for creating a Payment object out of a
     * PaymentRequestModel object.
     * 
     * @param requestModel
     *            DTO that is required to be mapped.
     * @return Payment object mapped.
     * @see PaymentRequestModel
     * @see Payment
     */
    Payment paymentRequestModelToPayment(PaymentRequestModel requestModel);

    /**
     * Generates a mapper for creating a PaymentResponseModel object out of a
     * Payment object.
     * 
     * @param payment
     *            DTO that is required to be mapped.
     * @return Payment object mapped.
     * @see Payment
     * @see PaymentResponseModel
     */
    @Mapping(source = Constant.MAPPER_STRING_LOAN_DOT_ID, target = Constant.MAPPER_STRING_LOAN_ID)
    PaymentResponseModel paymenToPaymentResponseModel(Payment payment);

}
