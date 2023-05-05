package com.proxiBanque.dto.received;

public class NewLoanDto {

    private Integer initialAmount;
    private Long duration;
    private Float interestRate;
    private Float insuranceRate;
    private Long clientId;


    protected NewLoanDto() {}


    public NewLoanDto(Integer initialAmount, Long duration, Float interestRate,
            Float insuranceRate, Long clientId) {
        this.initialAmount = initialAmount;
        this.duration = duration;
        this.interestRate = interestRate;
        this.insuranceRate = insuranceRate;
        this.clientId = clientId;
    }


    public Integer getInitialAmount() {
        return initialAmount;
    }


    public void setInitialAmount(Integer initialAmount) {
        this.initialAmount = initialAmount;
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

    public Long getClientId() {
        return clientId;
    }


    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    
    
}
