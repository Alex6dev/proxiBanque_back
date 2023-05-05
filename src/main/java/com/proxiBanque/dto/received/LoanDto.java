package com.proxiBanque.dto.received;

import java.sql.Timestamp;

import com.proxiBanque.model.Loan;

import jakarta.validation.constraints.NotBlank;

public class LoanDto {

    @NotBlank(message = "l'id doit être present")
    private Long id;

    @NotBlank(message = "l'initialAmount doit être present")
    private Integer initialAmount;
    
    @NotBlank(message = "le remainingAmount doit être present")
    private Integer remainingAmount;

    private Timestamp startOfLoan=null;

    private Long duration;

    @NotBlank(message = "l'interestRate doit être present")
    private Float interestRate;

    @NotBlank(message = "l'insuranceRate doit être present")
    private Float insuranceRate;

    private Boolean accept;

    protected LoanDto(){}

    public LoanDto(Loan loan){
        this.id=loan.getId();
        this.initialAmount=loan.getInitialAmount();
        this.remainingAmount=loan.getRemainingAmount();
        if(loan.getStartOfLoan()!=null)
            this.startOfLoan=loan.getStartOfLoan();
        this.duration=loan.getDuration();
        this.interestRate=loan.getInterestRate();
        this.insuranceRate=loan.getInsuranceRate();
        this.accept=loan.getAccept();
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

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
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
    

}
