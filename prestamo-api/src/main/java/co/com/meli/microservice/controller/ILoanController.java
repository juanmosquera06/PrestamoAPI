/**
 * 
 */
package co.com.meli.microservice.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import co.com.meli.microservice.dto.InstallmentResponseModel;
import co.com.meli.microservice.dto.LoanRequestModel;
import co.com.meli.microservice.dto.LoanResponseModel;
import co.com.meli.microservice.exception.BusinessException;
import co.com.meli.microservice.exception.DateException;
import co.com.meli.microservice.exception.EntityNotFoundException;
import co.com.meli.microservice.exception.NoDataFoundException;
import co.com.meli.microservice.util.Constant;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Define REST operations, methods and response entities about loans.
 * 
 * @since 0.0.1
 * @author Juan Felipe Mosquera
 *
 */
@Tag(name = Constant.DOC_STRING_TAG_NAME_LOAN, description = Constant.DOC_STRING_TAG_DESCRIPTION_LOAN)
public interface ILoanController {

    /**
     * Create a loan request.
     * 
     * @param loan
     *            loan identifier.
     * @return an entity that contains the loan identifier and loan installment.
     * @throws EntityNotFoundException
     *             if the client is not found to create the loan.
     * @throws NoDataFoundException
     *             if there are no loan conditions of the client's target to
     *             create the loan.
     * @throws BusinessException
     *             if the credit rate cannot be obtained or any of the values
     *             entered is an invalid value.
     */
    @Operation(summary = Constant.DOC_STRING_OPERATION_SUMMARY_CREATE_LOAN, description = Constant.DOC_STRING_OPERATION_DESCRIPTION_CREATE_LOAN, responses = {
            @ApiResponse(responseCode = Constant.COMMON_STRING_API_RESPONSE_CODE_CREATED, description = Constant.COMMON_STRING_API_RESPONSE_DESCRIPTION_CREATED),
            @ApiResponse(responseCode = Constant.COMMON_STRING_API_RESPONSE_CODE_NOT_FOUND, description = Constant.COMMON_STRING_API_RESPONSE_DESCRIPTION_NOT_FOUND),
            @ApiResponse(responseCode = Constant.COMMON_STRING_API_RESPONSE_CODE_INTERNAL_SERVER_ERROR, description = Constant.COMMON_STRING_API_RESPONSE_DESCRIPTION_INTERNAL_SERVER_ERROR) })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstallmentResponseModel> createLoan(
            @RequestBody LoanRequestModel loan)
            throws EntityNotFoundException, NoDataFoundException,
            BusinessException;

    /**
     * Returns all loans with date range filter.
     * 
     * @param dateFrom
     *            start date filter.
     * @param dateTo
     *            end date filter.
     * @return a list that contains all loans with conditions specified.
     * @throws NoDataFoundException
     *             if an error occurs getting the loans.
     * @throws DateException
     *             if the entered dates does not have the established format.
     */
    @Operation(summary = Constant.DOC_STRING_OPERATION_SUMMARY_GET_LOANS_BY_DATE_RANGE, description = Constant.DOC_STRING_OPERATION_DESCRIPTION_GET_LOANS_BY_DATE_RANGE, responses = {
            @ApiResponse(responseCode = Constant.COMMON_STRING_API_RESPONSE_CODE_OK, description = Constant.COMMON_STRING_API_RESPONSE_DESCRIPTION_OK),
            @ApiResponse(responseCode = Constant.COMMON_STRING_API_RESPONSE_CODE_NOT_FOUND, description = Constant.COMMON_STRING_API_RESPONSE_DESCRIPTION_NOT_FOUND),
            @ApiResponse(responseCode = Constant.COMMON_STRING_API_RESPONSE_CODE_INTERNAL_SERVER_ERROR, description = Constant.COMMON_STRING_API_RESPONSE_DESCRIPTION_INTERNAL_SERVER_ERROR) })
    @GetMapping(params = { Constant.COMMON_STRING_DATE_FROM,
            Constant.COMMON_STRING_DATE_TO })
    public ResponseEntity<List<LoanResponseModel>> getLoansByDateRange(
            @RequestParam(required = true, name = Constant.COMMON_STRING_DATE_FROM) String dateFrom,
            @RequestParam(required = true, name = Constant.COMMON_STRING_DATE_TO) String dateTo)
            throws NoDataFoundException, DateException;
}
