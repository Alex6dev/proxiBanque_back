package com.proxiBanque.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.slf4j.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proxiBanque.ProxiBanqueApplication;
import com.proxiBanque.dto.emis.AuditDto;
import com.proxiBanque.exception.CreditorAccountNotFoundException;
import com.proxiBanque.exception.DebitorAccountNotFoundException;
import com.proxiBanque.exception.InsufficientBalanceException;
import com.proxiBanque.exception.NegativeAmountException;
import com.proxiBanque.model.Account;
import com.proxiBanque.service.AccountServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class AccountController {

	private static final Logger logger= ProxiBanqueApplication.logger;

	private AccountServiceImpl accountService;

	public AccountController(AccountServiceImpl accountService) {
		this.accountService = accountService;
	}

	@PostMapping("/accounts")
	public ResponseEntity<List<Account>> findAccountsByClientId(@RequestBody Long clientId) {
		List<Account> accounts = accountService.findAccountsByClientId(clientId);
		if (!accounts.isEmpty())
			return ResponseEntity.ok(accounts);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@PostMapping("/accounts/audit")
	public ResponseEntity<AuditDto> auditByAdvisorId(@RequestBody Long advisorId) {
		Optional<AuditDto> auditData = accountService.auditByAdvisorId(advisorId);
		if (auditData.isPresent())
			return ResponseEntity.ok(auditData.get());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("/accounts/audit")
	public ResponseEntity<AuditDto> audit() {
		Optional<AuditDto> auditData = accountService.audit();
		if (auditData.isPresent())
			return ResponseEntity.ok(auditData.get());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@PutMapping("/account/{id}/transfer")
	public ResponseEntity<?> bankTransfer(@PathVariable(value = "id") Long debitorId,
			@RequestBody Map<String, String> transferDetails) {
		try {
			List<Account> accounts = accountService.bankTransfer(debitorId, transferDetails);
			return ResponseEntity.ok(accounts);
		} catch (NegativeAmountException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (InsufficientBalanceException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (DebitorAccountNotFoundException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		} catch (CreditorAccountNotFoundException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	
}
