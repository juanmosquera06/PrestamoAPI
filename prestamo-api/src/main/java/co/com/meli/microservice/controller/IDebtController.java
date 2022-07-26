/**
 * 
 */
package co.com.meli.microservice.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import co.com.meli.microservice.dto.DebtResponseModel;
import co.com.meli.microservice.enums.Target;
import co.com.meli.microservice.exception.BusinessException;
import co.com.meli.microservice.exception.DateException;
import co.com.meli.microservice.exception.EntityNotFoundException;
import co.com.meli.microservice.exception.NoDataFoundException;
import co.com.meli.microservice.util.Constant;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Define REST operations, methods and response entities about debts.
 * 
 * @since 0.0.1
 * @author Juan Felipe Mosquera
 *
 */
@Tag(name = Constant.DOC_STRING_TAG_NAME_DEBT, description = Constant.DOC_STRING_TAG_DESCRIPTION_DEBT)
public interface IDebtController {

    /**
     * Returns pending balance of loan or balance until a specified date.
     * 
     * @param loanId
     *            loan identifier.
     * @param date
     *            date filter.
     * @return an entity that contains the debt balance.
     * @throws EntityNotFoundException
     *             if the loan to consult is not created.
     * @throws NoDataFoundException
     *             if an error occurs consulting the payments applied to the
     *             loan.
     * @throws BusinessException
     *             if an error occurs obtaining the amount of the debt.
     * @throws DateException
     *             if the entered date does not have the established format.
     */
    @Operation(summary = Constant.DOC_STRING_OPERATION_SUMMARY_GET_DEBT_BY_LOAN, description = Constant.DOC_STRING_OPERATION_DESCRIPTION_GET_DEBT_BY_LOAN, responses = {
            @ApiResponse(responseCode = Constant.COMMON_STRING_API_RESPONSE_CODE_OK, description = Constant.COMMON_STRING_API_RESPONSE_DESCRIPTION_OK),
            @ApiResponse(responseCode = Constant.COMMON_STRING_API_RESPONSE_CODE_NOT_FOUND, description = Constant.COMMON_STRING_API_RESPONSE_DESCRIPTION_NOT_FOUND),
            @ApiResponse(responseCode = Constant.COMMON_STRING_API_RESPONSE_CODE_INTERNAL_SERVER_ERROR, description = Constant.COMMON_STRING_API_RESPONSE_DESCRIPTION_INTERNAL_SERVER_ERROR) })
    @GetMapping(path = Constant.SERVICE_STRING_PATH_GET_DEBT_BY_LOAN)
    public ResponseEntity<DebtResponseModel> getDebtByLoan(
            @PathVariable(Constant.COMMON_STRING_LOAN_ID) Long loanId,
            @RequestParam(name = Constant.COMMON_STRING_DATE) Optional<String> date)
            throws EntityNotFoundException, NoDataFoundException,
            BusinessException, DateException;

    /**
     * Returns pending balance of loans until a specified date or target.
     * 
     * @param date
     *            date filter.
     * @param target
     *            client Target
     * @return an entity that contains the debt balance.
     * @throws BusinessException
     *             if an error occurs obtaining the amount of the debt.
     * @throws DateException
     *             if the entered date does not have the established format.
     * @see Target
     */
    @Operation(summary = Constant.DOC_STRING_OPERATION_SUMMARY_GET_TOTAL_DEBT, description = Constant.DOC_STRING_OPERATION_DESCRIPTION_GET_TOTAL_DEBT, responses = {
            @ApiResponse(responseCode = Constant.COMMON_STRING_API_RESPONSE_CODE_OK, description = Constant.COMMON_STRING_API_RESPONSE_DESCRIPTION_OK),
            @ApiResponse(responseCode = Constant.COMMON_STRING_API_RESPONSE_CODE_INTERNAL_SERVER_ERROR, description = Constant.COMMON_STRING_API_RESPONSE_DESCRIPTION_INTERNAL_SERVER_ERROR) })
    @GetMapping()
    public ResponseEntity<DebtResponseModel> getTotalDebt(
            @RequestParam(name = Constant.COMMON_STRING_DATE) Optional<String> date,
            @RequestParam(name = Constant.COMMON_STRING_TARGET) Optional<Target> target)
            throws BusinessException, DateException;
}
