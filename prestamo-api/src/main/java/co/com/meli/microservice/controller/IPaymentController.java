/**
 * 
 */
package co.com.meli.microservice.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import co.com.meli.microservice.dto.PaymentRequestModel;
import co.com.meli.microservice.dto.PaymentResponseModel;
import co.com.meli.microservice.exception.BusinessException;
import co.com.meli.microservice.exception.EntityNotFoundException;
import co.com.meli.microservice.exception.NoDataFoundException;
import co.com.meli.microservice.util.Constant;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Define REST operations, methods and response entities about payments.
 * 
 * @since 0.0.1
 * @author Juan Felipe Mosquera
 *
 */
@Tag(name = Constant.DOC_STRING_TAG_NAME_PAYMENT, description = Constant.DOC_STRING_TAG_DESCRIPTION_PAYMENT)
public interface IPaymentController {

    /**
     * Apply a loan payment.
     * 
     * @param loanId
     *            loan identifier.
     * @param payment
     *            the amount of payment to apply.
     * @return an entity that contains payment identifier and the debt balance.
     * @throws EntityNotFoundException
     *             if the loan is not created.
     * @throws NoDataFoundException
     *             if there is an error getting the previous payments of the
     *             loan.
     * @throws BusinessException
     *             if payment amount exceeds the loan debt or any of the values
     *             entered is an invalid value
     */
    @Operation(summary = Constant.DOC_STRING_OPERATION_SUMMARY_RECORD_LOAN_PAYMENT, description = Constant.DOC_STRING_OPERATION_DESCRIPTION_RECORD_LOAN_PAYMENT, responses = {
            @ApiResponse(responseCode = Constant.COMMON_STRING_API_RESPONSE_CODE_CREATED, description = Constant.COMMON_STRING_API_RESPONSE_DESCRIPTION_CREATED),
            @ApiResponse(responseCode = Constant.COMMON_STRING_API_RESPONSE_CODE_NOT_FOUND, description = Constant.COMMON_STRING_API_RESPONSE_DESCRIPTION_NOT_FOUND),
            @ApiResponse(responseCode = Constant.COMMON_STRING_API_RESPONSE_CODE_INTERNAL_SERVER_ERROR, description = Constant.COMMON_STRING_API_RESPONSE_DESCRIPTION_INTERNAL_SERVER_ERROR) })
    @PostMapping(path = Constant.SERVICE_STRING_PATH_RECORD_LOAN_PAYMENT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaymentResponseModel> recordLoanPayment(
            @PathVariable(Constant.COMMON_STRING_LOAN_ID) Long loanId,
            @RequestBody PaymentRequestModel payment)
            throws EntityNotFoundException, NoDataFoundException,
            BusinessException;
}
