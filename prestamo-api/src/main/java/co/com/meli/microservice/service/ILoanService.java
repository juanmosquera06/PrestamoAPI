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
import co.com.meli.microservice.persistence.data.Loan;

/**
 * @author juan.mosquera
 *
 */
public interface ILoanService {

    public List<LoanResponseModel> findAllLoansByDateRange(String dateFrom,
            String dateTo);

    public InstallmentResponseModel saveLoan(LoanRequestModel requestModel);

    public Loan findById(Long id);

    public DebtResponseModel getDebtByIdLoanAndDateFilter(Long loanId,
            Optional<String> date);

}
