package com.proxiBanque.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proxiBanque.dto.received.LoanDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Loan {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer initialAmount;
    private Integer remainingAmount;
    private Timestamp startOfLoan=null;
    private Long duration;
    private Float interestRate;
    private Float insuranceRate;
    private Boolean accept=false;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client owner;

    protected Loan() {}

    public Loan(LoanDto loanDto){
        this.id=loanDto.getId();
        this.initialAmount=loanDto.getInitialAmount();
        this.remainingAmount=loanDto.getRemainingAmount();
        if(loanDto.getStartOfLoan()!=null)
            this.startOfLoan=loanDto.getStartOfLoan();
        this.duration=loanDto.getDuration();
        this.interestRate=loanDto.getInterestRate();
        this.insuranceRate=loanDto.getInsuranceRate();
        this.accept=loanDto.getAccept();
    }
    public Loan(Integer initialAmount, Integer remainingAmount, Timestamp startOfLoan, Float interestRate,
    Float insuranceRate, Boolean accept, Client owner,Long duration) {
        this.initialAmount = initialAmount;
        this.remainingAmount = remainingAmount;
        this.startOfLoan = startOfLoan;
        this.interestRate = interestRate;
        this.insuranceRate = insuranceRate;
        this.accept = accept;
        this.owner = owner;
        this.duration=duration;
    }

    public Loan(Integer initialAmount, Integer remainingAmount, Float interestRate, Float insuranceRate, Boolean accept,
            Client owner,Long duration) {
        this.initialAmount = initialAmount;
        this.remainingAmount = remainingAmount;
        this.interestRate = interestRate;
        this.insuranceRate = insuranceRate;
        this.accept = accept;
        this.owner = owner;
        this.duration=duration;
    }

    

    public Loan(Integer initialAmount, Long duration, Float interestRate, Float insuranceRate,
            Client owner) {
        this.initialAmount = initialAmount;
        this.remainingAmount = null;
        this.duration = duration;
        this.interestRate = interestRate;
        this.insuranceRate = insuranceRate;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getInitialAmount() {
        return initialAmount;
    }

    public void setInitialAmount(Integer initialAmount) {
        this.initialAmount = initialAmount;
    }

    public Integer getRemainingAmount() {
        return remainingAmount;
    }

    public void setRemainingAmount(Integer remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    public Timestamp getStartOfLoan() {
        return startOfLoan;
    }

    public void setStartOfLoan(Timestamp startOfLoan) {
        this.startOfLoan = startOfLoan;
    }

    public Float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Float interestRate) {
        this.interestRate = interestRate;
    }

    public Float getInsuranceRate() {
        return insuranceRate;
    }

    public void setInsuranceRate(Float insuranceRate) {
        this.insuranceRate = insuranceRate;
    }

    public Boolean getAccept() {
        return accept;
    }

    public void setAccept(Boolean accept) {
        this.accept = accept;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

     

}
