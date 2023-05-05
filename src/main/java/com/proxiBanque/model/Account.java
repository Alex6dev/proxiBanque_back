package com.proxiBanque.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long accountNb;

	private Double balance;
	private LocalDate openingDate;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client owner;

	protected Account() {
	}

	public Account(Double balance, LocalDate openingDate, Client owner) {
		this.balance = balance;
		this.openingDate = openingDate;
		this.owner = owner;
	}

	public long getAccountNb() {
		return accountNb;
	}

	public void setAccountNb(long accountNb) {
		this.accountNb = accountNb;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public LocalDate getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(LocalDate openingDate) {
		this.openingDate = openingDate;
	}

	public Client getOwner() {
		return owner;
	}

	public void setOwner(Client owner) {
		this.owner = owner;
	}
}
