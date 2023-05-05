package com.proxiBanque.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;

@Entity
public class SavingsAccount extends Account {
	private Double interest;

	protected SavingsAccount() {
	}

	public SavingsAccount(Double balance, LocalDate openingDate, Client owner, Double interest) {
		super(balance, openingDate, owner);
		this.interest = interest;
	}

	public Double getInterest() {
		return interest;
	}

	public void setInterest(Double interest) {
		this.interest = interest;
	}
}
