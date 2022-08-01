/**
 * 
 */
package co.com.meli.microservice.service;

import java.util.List;
import java.util.Optional;

import co.com.meli.microservice.dto.DebtResponseModel;
import co.com.meli.microservice.dto.InstallmentResponseModel;
import co.com.meli.microservice.dto.LoanRequestModel;
import co.com.meli.microservice.dto.LoanResponseModel;
import co.com.meli.microservice.exception.BusinessException;
import co.com.meli.microservice.exception.DateException;
import co.com.meli.microservice.exception.EntityNotFoundException;
import co.com.meli.microservice.exception.NoDataFoundException;

/**
 * Loan related business logic interface.
 * 
 * @since 0.0.1
 * @author Juan Felipe Mosquera
 *
 */
public interface ILoanService {

    /**
     * Get all loans by date range.
     * 
     * @param dateFrom
     *            start date.
     * @param dateTo
     *            end date.
     * @return a list with information of loans.
     * @throws NoDataFoundException
     *             if an error occurred getting loans.
     * @throws DateException
     *             if the entered dates does not have the established format.
     */
    public List<LoanResponseModel> findAllLoansByDateRange(String dateFrom,
            String dateTo) throws NoDataFoundException, DateException;

    /**
     * Record a loan calculating rate and installment.
     * 
     * @param requestModel
     *            DTO with information of loan.
     * @return object with information of installment.
     * @throws EntityNotFoundException
     *             if the client is not found to create the loan.
     * @throws NoDataFoundException
     *             if there are no loan conditions of the client's target to
     *             create the loan.
     * @throws BusinessException
     *             if the credit rate cannot be obtained or any of the values
     *             entered is an invalid value.
     */
    public InstallmentResponseModel saveLoan(LoanRequestModel requestModel)
            throws EntityNotFoundException, NoDataFoundException,
            BusinessException;

    /**
     * Get loan debt by loan and date filter.
     * 
     * @param loanId
     *            loan identifier.
     * @param date
     *            date filter.
     * @return object with information of debt.
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
    public DebtResponseModel getDebtByIdLoanAndDateFilter(Long loanId,
            Optional<String> date)
            throws EntityNotFoundException, NoDataFoundException,
            BusinessException, DateException;

    /**
     * Get loan debt by Target and date filter.
     * 
     * @param date
     *            date filter.
     * @param target
     *            target filter.
     * @return object with information of debt.
     * @throws BusinessException
     *             if an error occurs obtaining the amount of the debt.
     * @throws DateException
     *             if the entered date does not have the established format.
     * @see Target
     */
    public DebtResponseModel getDebtByTargetAndDateFilter(Optional<String> date,
            Optional<co.com.meli.microservice.enums.Target> target)
            throws BusinessException, DateException;

}
