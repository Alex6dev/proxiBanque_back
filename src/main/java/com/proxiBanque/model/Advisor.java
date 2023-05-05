package com.proxiBanque.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Advisor extends Person{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	private String firstName;
	private String phone;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "agency_id")
	@JsonIgnore
	private Agency agency;

	
	public Advisor() {}

	public Advisor( String name, String firstName, String phone, 
			String mail, String password,Agency agency) {
        super(mail, password);

		this.name = name;
		this.firstName = firstName;
		this.phone = phone;
		this.agency = agency;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
    public Agency getAgency() {
        return agency;
    }
	public void setAgency(Agency agency) {
        this.agency = agency;
    }

}
