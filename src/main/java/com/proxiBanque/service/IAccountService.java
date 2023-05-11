package com.proxiBanque.service;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.proxiBanque.dto.emis.AuditDto;
import com.proxiBanque.exception.CreditorAccountNotFoundException;
import com.proxiBanque.exception.DebitorAccountNotFoundException;
import com.proxiBanque.exception.InsufficientBalanceException;
import com.proxiBanque.exception.NegativeAmountException;
import com.proxiBanque.model.Account;


public interface IAccountService {
    List<Account> findAccountsByClientId(Long clientId);
	Optional<AuditDto> audit();
	Optional<AuditDto> auditByAdvisorId(Long advisorId);
    List<Account> bankTransfer(Long debitorId, Map<String, String> transferDetails)throws NegativeAmountException, InsufficientBalanceException, DebitorAccountNotFoundException,
    CreditorAccountNotFoundException;

}
