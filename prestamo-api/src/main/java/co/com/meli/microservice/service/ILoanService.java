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
 * @author juan.mosquera
 *
 */
public interface ILoanService {

    public List<LoanResponseModel> findAllLoansByDateRange(String dateFrom,
            String dateTo) throws NoDataFoundException, DateException;

    public InstallmentResponseModel saveLoan(LoanRequestModel requestModel)
            throws EntityNotFoundException, NoDataFoundException,
            BusinessException;

    public DebtResponseModel getDebtByIdLoanAndDateFilter(Long loanId,
            Optional<String> date)
            throws EntityNotFoundException, NoDataFoundException,
            BusinessException, DateException;

    public DebtResponseModel getDebtByTargetAndDateFilter(Optional<String> date,
            Optional<co.com.meli.microservice.enums.Target> target)
            throws BusinessException, DateException;

}
