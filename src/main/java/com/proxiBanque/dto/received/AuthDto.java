package com.proxiBanque.dto.received;

import jakarta.validation.constraints.NotBlank;

public class AuthDto {

    @NotBlank
    private String identifiant;
    
    @NotBlank
    private String mdp;

    protected AuthDto(){}
    
    public AuthDto(String identifiant, String mdp) {
        this.identifiant = identifiant;
        this.mdp = mdp;
    }
    
    public String getIdentifiant() {
        return identifiant;
    }
    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }
    public String getMdp() {
        return mdp;
    }
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }


}
