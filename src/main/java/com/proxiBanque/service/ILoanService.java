package com.proxiBanque.service;

import java.util.Set;

import com.proxiBanque.dto.received.LoanDto;
import com.proxiBanque.dto.received.NewLoanDto;
import com.proxiBanque.exception.ForbidenException;
import com.proxiBanque.model.Loan;

public interface ILoanService {
    Set<Loan> getAllLoanByIdClient(Long idClient);
    LoanDto acceptLoan(Loan loan,Long idClient) throws ForbidenException;
    LoanDto createLoan(NewLoanDto newLoanDto) throws ForbidenException;
}
