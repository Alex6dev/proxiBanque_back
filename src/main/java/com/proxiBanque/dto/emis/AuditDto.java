package com.proxiBanque.dto.emis;

import java.util.List;

import com.proxiBanque.model.Account;

public class AuditDto {
	private int numberOfAccounts;
	private int numberOfOverdrawnAccounts;
	private Double totalOverdraft;
	private List<Account> overdrawnAccounts;
	
	public AuditDto() {}
	
	public AuditDto(int numberOfAccounts, int numberOfOverdrawnAccounts, Double totalOverdraft,
			List<Account> overdrawnAccounts) {
		this.numberOfAccounts = numberOfAccounts;
		this.numberOfOverdrawnAccounts = numberOfOverdrawnAccounts;
		this.totalOverdraft = totalOverdraft;
		this.overdrawnAccounts = overdrawnAccounts;
	}

	public int getNumberOfAccounts() {
		return numberOfAccounts;
	}

	public void setNumberOfAccounts(int numberOfAccounts) {
		this.numberOfAccounts = numberOfAccounts;
	}

	public int getNumberOfOverdrawnAccounts() {
		return numberOfOverdrawnAccounts;
	}

	public void setNumberOfOverdrawnAccounts(int numberOfOverdrawnAccounts) {
		this.numberOfOverdrawnAccounts = numberOfOverdrawnAccounts;
	}

	public Double getTotalOverdraft() {
		return totalOverdraft;
	}

	public void setTotalOverdraft(Double totalOverdraft) {
		this.totalOverdraft = totalOverdraft;
	}

	public List<Account> getOverdrawnAccounts() {
		return overdrawnAccounts;
	}

	public void setOverdrawnAccounts(List<Account> overdrawnAccounts) {
		this.overdrawnAccounts = overdrawnAccounts;
	}
}
