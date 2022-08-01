/**
 * 
 */
package co.com.meli.microservice.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import co.com.meli.microservice.dto.DebtResponseModel;
import co.com.meli.microservice.dto.InstallmentResponseModel;
import co.com.meli.microservice.dto.LoanRequestModel;
import co.com.meli.microservice.dto.LoanResponseModel;
import co.com.meli.microservice.exception.BusinessException;
import co.com.meli.microservice.exception.DateException;
import co.com.meli.microservice.exception.EntityNotFoundException;
import co.com.meli.microservice.exception.NoDataFoundException;
import co.com.meli.microservice.persistence.data.Client;
import co.com.meli.microservice.persistence.data.Loan;
import co.com.meli.microservice.persistence.data.Payment;
import co.com.meli.microservice.repository.ILoanRepository;
import co.com.meli.microservice.repository.IPaymentRepository;
import co.com.meli.microservice.util.CommonUtil;
import co.com.meli.microservice.util.Constant;
import co.com.meli.microservice.util.MapperUtil;
import lombok.AllArgsConstructor;

/**
 * @author juan.mosquera
 *
 */
@Service(value = Constant.SERVICE_STRING_LOAN)
@AllArgsConstructor
public class LoanService implements ILoanService {

    private ILoanRepository loanRepository;
    private IClientService clientService;
    private IPaymentRepository paymentRepository;
    private MapperUtil mapperUtil;

    @Override
    public List<LoanResponseModel> findAllLoansByDateRange(String dateFrom,
            String dateTo) throws NoDataFoundException, DateException {
        List<Loan> loans = null;
        LocalDateTime creationDateStart = null;
        LocalDateTime creationDateEnd = null;

        try {
            creationDateStart = CommonUtil.parseStringToStartOfDayDate(dateFrom,
                    Constant.COMMON_STRING_DATE_FORMAT);
            creationDateEnd = CommonUtil.parseStringToEndOfDayDate(dateTo,
                    Constant.COMMON_STRING_DATE_FORMAT);

            loans = loanRepository.findAllByCreationDateBetween(
                    creationDateStart, creationDateEnd);
            if (null == loans) {
                throw new NoDataFoundException(
                        String.format(Constant.ERROR_STRING_NOT_DATA_FOUND,
                                Loan.class.getSimpleName()));
            }

        } catch (IllegalArgumentException | DateTimeParseException dtp) {
            throw new DateException(
                    Constant.ERROR_STRING_INVALID_PATTERN_OR_DATE_CANNOT_BE_PARSE);
        }

        return mapperUtil.loanToLoanResponseModels(loans);
    }

    @Override
    public InstallmentResponseModel saveLoan(LoanRequestModel requestModel)
            throws EntityNotFoundException, NoDataFoundException,
            BusinessException {
        Loan loan = null;
        Loan entity = null;

        loan = mapperUtil.loanRequestModelToLoan(requestModel);
        entity = loanRepository.save(buildLoanEntity(loan, requestModel));

        return mapperUtil.loanToInstallmentResponseModel(entity);
    }

    private Loan buildLoanEntity(Loan loan, LoanRequestModel requestModel)
            throws EntityNotFoundException, NoDataFoundException,
            BusinessException {
        Client client = null;
        Map<String, Double> loanConditions = null;
        Double rate = null;

        if (!CommonUtil.isValidNumberValue(requestModel.getAmount())) {
            throw new BusinessException(String.format(
                    Constant.ERROR_STRING_VALUE_IS_NOT_A_VALID_NUMBER,
                    Constant.COMMON_STRING_AMOUNT));
        }

        if (!CommonUtil.isValidNumberValue(requestModel.getTerm())) {
            throw new BusinessException(String.format(
                    Constant.ERROR_STRING_VALUE_IS_NOT_A_VALID_NUMBER,
                    Constant.COMMON_STRING_TERM));
        }

        client = clientService.findById(requestModel.getUserId());

        loan.setClient(client);

        loanConditions = clientService.findActiveLoanConditionsByClient(client);

        loan.setRate(loanConditions.get(Constant.LOAN_CONDITION_STRING_RATE));
        if (null == loan.getRate()) {
            throw new BusinessException(
                    Constant.ERROR_STRING_LOAN_RATE_NOT_FOUND);
        }

        rate = CommonUtil.calculateMonthlyRate(loan.getRate());
        loan.setInstallment(CommonUtil.calculateLoanInstallment(rate,
                requestModel.getTerm(), loan.getAmount()));
        if (null == loan.getInstallment()) {
            throw new BusinessException(
                    Constant.ERROR_STRING_ERROR_GETTING_LOAN_INSTALLMENT);
        }

        loan.setStatus(Constant.COMMON_INTEGER_ACTIVE_STATUS);
        loan.setCreationUser(Constant.COMMON_STRING_CREATION_USER);
        loan.setCreationDate(LocalDateTime.now());

        return loan;
    }

    @Override
    public DebtResponseModel getDebtByIdLoanAndDateFilter(Long loanId,
            Optional<String> date) throws EntityNotFoundException,
            NoDataFoundException, BusinessException, DateException {
        Loan loan = null;
        List<Payment> payments = null;
        LocalDateTime dateFilter = null;
        DebtResponseModel response = null;
        Double debt = null;

        try {
            loan = loanRepository.findById(loanId)
                    .orElseThrow(() -> new EntityNotFoundException(String
                            .format(Constant.ERROR_STRING_ENTITY_NOT_FOUND,
                                    Loan.class.getSimpleName(), loanId)));

            payments = paymentRepository.findAllByLoan(loan);
            if (null == payments) {
                throw new NoDataFoundException(
                        String.format(Constant.ERROR_STRING_NOT_DATA_FOUND,
                                Payment.class.getSimpleName()));
            }

            dateFilter = date.isPresent()
                    ? CommonUtil.parseStringToEndOfDayDate(date.get(),
                            Constant.COMMON_STRING_DATE_FORMAT)
                    : null;

            if (null == dateFilter) {
                debt = CommonUtil.calculateLoanDebt(loan, payments);
            } else {
                debt = CommonUtil.calculateLoanDebt(loan, payments, dateFilter);
            }

            if (null == debt) {
                throw new BusinessException(
                        Constant.ERROR_STRING_ERROR_GETTING_LOAN_DEBT);
            }

            response = new DebtResponseModel();
            response.setDebt(debt);

        } catch (IllegalArgumentException | DateTimeParseException dtp) {
            throw new DateException(
                    Constant.ERROR_STRING_INVALID_PATTERN_OR_DATE_CANNOT_BE_PARSE);
        }

        return response;
    }

    @Override
    public DebtResponseModel getDebtByTargetAndDateFilter(Optional<String> date,
            Optional<co.com.meli.microservice.enums.Target> target)
            throws BusinessException, DateException {
        Iterable<Loan> loans = null;
        Stream<Loan> streamLoans = null;
        DebtResponseModel response = null;
        Double debt = null;
        LocalDateTime dateFilter = null;

        try {
            loans = loanRepository.findAll();

            streamLoans = StreamSupport.stream(loans.spliterator(), false);

            if (target.isPresent()) {
                streamLoans = streamLoans.filter(loan -> target.get() == loan
                        .getClient().getTarget().getDescription());
            }

            if (date.isPresent()) {

                dateFilter = CommonUtil.parseStringToEndOfDayDate(date.get(),
                        Constant.COMMON_STRING_DATE_FORMAT);

                final LocalDateTime finalDateFilter = dateFilter;
                debt = streamLoans
                        .map(loan -> CommonUtil.calculateLoanDebt(loan,
                                paymentRepository.findAllByLoan(loan),
                                finalDateFilter))
                        .collect(Collectors.summingDouble(Double::doubleValue));

            } else {
                debt = streamLoans
                        .map(loan -> CommonUtil.calculateLoanDebt(loan,
                                paymentRepository.findAllByLoan(loan)))
                        .collect(Collectors.summingDouble(Double::doubleValue));
            }

            if (null == debt) {
                throw new BusinessException(
                        Constant.ERROR_STRING_ERROR_GETTING_LOAN_DEBT);
            }

            response = new DebtResponseModel();
            response.setDebt(debt);

        } catch (IllegalArgumentException | DateTimeParseException dtp) {
            throw new DateException(
                    Constant.ERROR_STRING_INVALID_PATTERN_OR_DATE_CANNOT_BE_PARSE);
        }

        return response;
    }

}
