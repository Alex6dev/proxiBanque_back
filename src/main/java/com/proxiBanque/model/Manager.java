package com.proxiBanque.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
public class Manager extends Person{
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String firstName;
	private String phone;
    @OneToOne
    @JoinColumn(name = "agency_id", unique=true)
    @MapsId
    private Agency agency;

    protected Manager() {}

    public Manager(String name, String firstName, String phone,String mail, String password,Agency agency) {
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
