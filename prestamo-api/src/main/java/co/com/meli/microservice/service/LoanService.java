/**
 * 
 */
package co.com.meli.microservice.service;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.com.meli.microservice.dto.DebtResponseModel;
import co.com.meli.microservice.dto.InstallmentResponseModel;
import co.com.meli.microservice.dto.LoanRequestModel;
import co.com.meli.microservice.dto.LoanResponseModel;
import co.com.meli.microservice.persistence.data.Client;
import co.com.meli.microservice.persistence.data.Loan;
import co.com.meli.microservice.persistence.data.Payment;
import co.com.meli.microservice.repository.ILoanRepository;
import co.com.meli.microservice.util.CommonUtil;
import co.com.meli.microservice.util.Constant;
import co.com.meli.microservice.util.MapperUtil;
import lombok.AllArgsConstructor;

/**
 * @author juan.mosquera
 *
 */
@Service(value = "loanService")
@AllArgsConstructor
public class LoanService implements ILoanService {

    private ILoanRepository loanRepository;
    private IClientService clientService;
    private IPaymentService paymentService;
    private MapperUtil mapperUtil;

    @Override
    public List<LoanResponseModel> findAllLoansByDateRange(String dateFrom,
            String dateTo) {
        List<Loan> loanEntities = null;
        Date creationDateStart = null;
        Date creationDateEnd = null;

        try {
            creationDateStart = CommonUtil.parseStringToDate(dateFrom,
                    Constant.COMMON_STRING_DATE_FORMAT);
            creationDateEnd = CommonUtil.parseStringToDate(dateTo,
                    Constant.COMMON_STRING_DATE_FORMAT);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        loanEntities = loanRepository.findAllByCreationDateBetween(
                creationDateStart, creationDateEnd);

        return mapperUtil.loanToLoanResponseModels(loanEntities);
    }

    @Override
    public InstallmentResponseModel saveLoan(LoanRequestModel requestModel) {
        Loan loan = null;
        Loan entity = null;

        loan = mapperUtil.loanRequestModelToLoan(requestModel);
        entity = loanRepository.save(buildLoanEntity(loan, requestModel));

        return mapperUtil.loanToInstallmentResponseModel(entity);
    }
    
    @Override
    public Loan findById(Long id) {
        // TODO Null Pointer
        return loanRepository.findById(id).orElse(null);
    }

    private Loan buildLoanEntity(Loan loan, LoanRequestModel requestModel) {
        Client client = null;
        Map<String, Double> loanConditions = null;
        Double rate = null;

        client = clientService.findById(requestModel.getUserId());
        if (null == client) {
            return null;
            // Not implemented yet
        }

        loan.setClient(client);

        loanConditions = clientService.findActiveLoanConditionsByClient(client);
        if (null == loanConditions || loanConditions.isEmpty()) {
            return null;
            // Not implemented yet
        }

        loan.setRate(loanConditions.get(Constant.LOAN_CONDITION_STRING_RATE));
        if (null == loan.getRate()) {
            return null;
            // Not implemented yet
        }

        rate = CommonUtil.calculateMonthlyRate(loan.getRate());
        loan.setInstallment(CommonUtil.calculateLoanInstallment(rate,
                requestModel.getTerm(), loan.getAmount()));
        if (null == loan.getInstallment()) {
            return null;
            // Not implemented yet
        }

        loan.setStatus(Constant.COMMON_INTEGER_ACTIVE_STATUS);
        loan.setCreationUser(Constant.COMMON_STRING_CREATION_USER);
        loan.setCreationDate(new Date());

        return loan;
    }

    @Override
    public DebtResponseModel getDebtByIdLoanAndDateFilter(Long loanId,
            Optional<String> date) {
        Loan loan = null;
        List<Payment> payments = null;
        Date dateFilter = null;
        DebtResponseModel response = null;
        Double debt = null;
        Calendar calendar = null;

        // TODO Null pointer
        loan = loanRepository.findById(loanId).orElse(null);
        if (null == loan) {
            return null;
            // Not implemented yet
        }

        try {
            dateFilter = date.isPresent()
                    ? CommonUtil.parseStringToEndDate(date.get(),
                            Constant.COMMON_STRING_END_DATE_FORMAT)
                    : null;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        payments = paymentService.getPaymentsByLoanAndDateRange(loan,
                loan.getCreationDate(),
                null == dateFilter ? new Date() : dateFilter);
        if (null == payments) {
            return null;
            // Not implemented yet
        }

        debt = CommonUtil.calculateLoanDebt(loan, payments);
        if (null == debt) {
            return null;
            // Not implemented yet
        }

        response = new DebtResponseModel();
        response.setDebt(debt);

        return response;
    }

}
