package com.proxiBanque.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	private String firstName;
	private String address;
	private String postcode;
	private String city;
	private String phone;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "advisor_id")
	private Advisor advisor;

	@JsonIgnore
	@OneToMany(mappedBy = "owner", orphanRemoval = true)
	private Set<Account> accounts = new HashSet<>();

	@JsonIgnore
	@OneToMany(mappedBy = "owner",orphanRemoval = true)
	private Set<Loan> loans=new HashSet<>();

	protected Client() {
	}

	public Client(String name, String firstName, String address, String postcode, String city, String phone) {
		this.name = name;
		this.firstName = firstName;
		this.address = address;
		this.postcode = postcode;
		this.city = city;
		this.phone = phone;
	}

	public Client(String name, String firstName, String address, String postcode, String city, String phone,
			Advisor advisor) {
		this.name = name;
		this.firstName = firstName;
		this.address = address;
		this.postcode = postcode;
		this.city = city;
		this.phone = phone;
		this.advisor = advisor;
	}

	public Client(String name, String firstName, String address, String postcode, String city, String phone,
			Advisor advisor, Set<Account> accounts,Set<Loan> loans) {
		this.name = name;
		this.firstName = firstName;
		this.address = address;
		this.postcode = postcode;
		this.city = city;
		this.phone = phone;
		this.advisor = advisor;
		this.accounts = accounts;
		this.loans=loans;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Advisor getAdvisor() {
		return advisor;
	}

	public void setAdvisor(Advisor advisor) {
		this.advisor = advisor;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	public Set<Loan> getLoans() {
		return loans;
	}

	public void setLoans(Set<Loan> loans) {
		this.loans = loans;
	}

	
}
