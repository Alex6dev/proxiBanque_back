package com.proxiBanque.dto.received;

import jakarta.validation.constraints.NotBlank;

public class AcceptLaonDto {
    @NotBlank(message = "le loan doit être present")
    private LoanDto loan;

    @NotBlank(message = "l'idClient doit être present")
    private Long idClient;

    public LoanDto getLoan() {
        return loan;
    }

    public void setLoan(LoanDto loan) {
        this.loan = loan;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    
}
