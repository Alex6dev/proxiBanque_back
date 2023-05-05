package com.proxiBanque.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.proxiBanque.dto.emis.AuditDto;
import com.proxiBanque.exception.CreditorAccountNotFoundException;
import com.proxiBanque.exception.DebitorAccountNotFoundException;
import com.proxiBanque.exception.InsufficientBalanceException;
import com.proxiBanque.exception.NegativeAmountException;
import com.proxiBanque.model.Account;
import com.proxiBanque.model.CheckingAccount;
import com.proxiBanque.repository.AccountRepository;

@Service
public class AccountService {
	private AccountRepository accountRepository;

	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	public Optional<Account> findAccountById(Long accountId) {
		return accountRepository.findById(accountId);
	}

	public List<Account> findAccountsByClientId(Long clientId) {
		return accountRepository.findByOwnerId(clientId);
	}
	
	public Optional<AuditDto> audit() {
		AuditDto audit = new AuditDto();
		List<Account> accounts;
		accounts = accountRepository.findAll();
		if (accounts.isEmpty()) 
			return Optional.empty();
		accounts = accounts.stream().filter(account -> account instanceof CheckingAccount).collect(Collectors.toList());
		audit.setNumberOfAccounts(accounts.size());
		audit.setOverdrawnAccounts(accounts.stream().filter(account -> account.getBalance() < 0).collect(Collectors.toList()));
		audit.setNumberOfOverdrawnAccounts(audit.getOverdrawnAccounts().size());
		Double totalOverdraft = 0.0;
		for (Account account : audit.getOverdrawnAccounts()) {
			totalOverdraft += account.getBalance();
		}
		audit.setTotalOverdraft(totalOverdraft);
		return Optional.of(audit);
	}

	public Optional<AuditDto> auditByAdvisorId(Long advisorId) {
		AuditDto audit = new AuditDto();
		List<Account> accounts;
		accounts = accountRepository.findByOwnerAdvisorId(advisorId);
		if (accounts.isEmpty()) 
			return Optional.empty();
		accounts = accounts.stream().filter(account -> account instanceof CheckingAccount).collect(Collectors.toList());
		audit.setNumberOfAccounts(accounts.size());
		audit.setOverdrawnAccounts(accounts.stream().filter(account -> account.getBalance() < 0).collect(Collectors.toList()));
		audit.setNumberOfOverdrawnAccounts(audit.getOverdrawnAccounts().size());
		Double totalOverdraft = 0.0;
		for (Account account : audit.getOverdrawnAccounts()) {
			totalOverdraft += account.getBalance();
		}
		audit.setTotalOverdraft(totalOverdraft);
		return Optional.of(audit);
	}

	public List<Account> bankTransfer(Long debitorId, Map<String, String> transferDetails)
			throws NegativeAmountException, InsufficientBalanceException, DebitorAccountNotFoundException,
			CreditorAccountNotFoundException {
		Optional<Account> debitorAccountData = accountRepository.findById(debitorId);
		Optional<Account> creditorAccountData = accountRepository
				.findById(Long.parseLong(transferDetails.get("creditorId")));
		List<Account> accounts = new ArrayList<>();

		if (debitorAccountData.isPresent()) {
			if (creditorAccountData.isPresent()) {
				Double amount = Double.parseDouble(transferDetails.get("amount"));
				Account debitorAccount = debitorAccountData.get();
				Account creditorAccount = creditorAccountData.get();

				if (amount > 0) {
					if (debitorAccount instanceof CheckingAccount) {
						if ((debitorAccount.getBalance() - amount) >= ((CheckingAccount) debitorAccount).getOverdraft()
								* -1) {
							debitorAccount.setBalance(debitorAccount.getBalance() - amount);
							creditorAccount.setBalance(creditorAccount.getBalance() + amount);
							accountRepository.save(creditorAccount);
							accountRepository.save(debitorAccount);
							accounts.add(creditorAccount);
							accounts.add(debitorAccount);
						} else
							throw new InsufficientBalanceException("Le solde du compte est insuffisant");
					} else if ((debitorAccount.getBalance() - amount) >= 0) {
						debitorAccount.setBalance(debitorAccount.getBalance() - amount);
						creditorAccount.setBalance(creditorAccount.getBalance() + amount);
						accountRepository.save(creditorAccount);
						accountRepository.save(debitorAccount);
						accounts.add(creditorAccount);
						accounts.add(debitorAccount);
					} else
						throw new InsufficientBalanceException("Le solde du compte est insuffisant");
				} else
					throw new NegativeAmountException("Le montant ne peut pas être négatif");
			} else
				throw new DebitorAccountNotFoundException("Le compte débiteur n'existe pas");
		} else
			throw new CreditorAccountNotFoundException("Le compte créditeur n'existe pas");
		return accounts;
	}
}
