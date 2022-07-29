/**
 * 
 */
package co.com.meli.microservice.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import co.com.meli.microservice.dto.LoanDto;
import co.com.meli.microservice.persistence.data.Client;
import co.com.meli.microservice.persistence.data.Loan;
import co.com.meli.microservice.repository.ILoanRepository;
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

    private MapperUtil mapperUtil;

    @Override
    public Loan findById(Long id) {
        return loanRepository.findById(id).orElseThrow(null);
    }

    @Override
    public List<Loan> findAllLoans() {
        return (List<Loan>) loanRepository.findAll();
    }

    @Override
    public LoanDto saveLoan(LoanDto loan) {
        Loan entity = mapperUtil.loanDtoToLoan(loan);
        loanRepository.save(buildLoanEntity(entity, loan));

        return new LoanDto();
    }
    
    private Loan buildLoanEntity(Loan loan, LoanDto loanDto) {
        Client client = new Client();
        loan.setClient(client);
        loan.getClient().setId(loanDto.getUserId());

        loan.setStatus(Constant.COMMON_INTEGER_STATUS);
        loan.setCreationUser(Constant.COMMON_STRING_CREATION_USER);
        loan.setCreationDate(new Date());

        return loan;
    }

}
