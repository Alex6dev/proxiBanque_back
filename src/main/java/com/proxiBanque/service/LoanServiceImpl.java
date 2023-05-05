package com.proxiBanque.service;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proxiBanque.dto.received.LoanDto;
import com.proxiBanque.dto.received.NewLoanDto;
import com.proxiBanque.exception.ForbidenException;
import com.proxiBanque.model.Client;
import com.proxiBanque.model.Loan;
import com.proxiBanque.repository.ClientRepository;
import com.proxiBanque.repository.LoanRepository;

@Service
public class LoanServiceImpl implements ILoanService {

    @Autowired
    private LoanRepository loanRepository;
    
    @Autowired
    private ClientRepository clientRepository;

    public Set<Loan> getAllLoanByIdClient(Long idClient) {
        return loanRepository.findByOwnerId(idClient);

    }

    public LoanDto acceptLoan(Loan loan, Long idClient) throws ForbidenException{
        if(loan.getAccept().equals(true) && loan.getStartOfLoan()==null){
            loan.setOwner(clientRepository.findById(idClient).get());
            loan.setStartOfLoan(new Timestamp(System.currentTimeMillis()));
            loan.setAccept(true);
            return new LoanDto(loanRepository.save(loan));
        }else{
            throw new ForbidenException("Le prêt passer est déjà valider par le client");
        }
    }

    @Override
    public LoanDto createLoan(NewLoanDto newLoanDto) throws ForbidenException {
        Optional<Client> clientObs = clientRepository.findById(newLoanDto.getClientId());
        if(clientObs.isPresent()){
            //convert Month to Millisecond
            Long timeDurationMonth=newLoanDto.getDuration();
            Long timeDurationMS=(timeDurationMonth*2629800000l);

            Loan loan= new Loan(
                newLoanDto.getInitialAmount(), 
                timeDurationMS,newLoanDto.getInterestRate(), newLoanDto.getInsuranceRate(), 
                clientObs.get());
            return new LoanDto(loanRepository.save(loan));
        }else{
            throw new ForbidenException("Le client demandé n'existe pas en BDD");
        }
    }
}
