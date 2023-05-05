package com.proxiBanque.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String city;
    private String country;

    @OneToOne(mappedBy = "agency", cascade = CascadeType.PERSIST)
    private Manager manager;

    @OneToMany(mappedBy = "agency",cascade = CascadeType.PERSIST)
    private Set<Advisor> advisors= new HashSet<Advisor>();

    protected Agency(){}

    public Agency(String city, String country) {
        this.city = city;
        this.country = country;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public Manager getManager() {
        return manager;
    }
    public void setManager(Manager manager) {
        this.manager = manager;
    }
    public Set<Advisor> getAdvisors() {
        return advisors;
    }
    public void setAdvisors(Set<Advisor> advisors) {
        this.advisors = advisors;
    }
    public void addAdvisor(Advisor advisor) {
        advisors.add(advisor);
    }

    
}
