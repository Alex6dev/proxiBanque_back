package com.proxiBanque.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;

@Entity
public class CheckingAccount extends Account {
	private Double overdraft;
	private ECardType card;

	protected CheckingAccount() {
	}

	public CheckingAccount(Double balance, LocalDate openingDate, Client owner, Double overdraft, ECardType card) {
		super(balance, openingDate, owner);
		this.overdraft = overdraft;
		this.card = card;
	}

	public Double getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(Double overdraft) {
		this.overdraft = overdraft;
	}

	public ECardType getCard() {
		return card;
	}

	public void setCard(ECardType card) {
		this.card = card;
	}
}
