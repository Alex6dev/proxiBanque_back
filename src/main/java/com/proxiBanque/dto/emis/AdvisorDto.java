package com.proxiBanque.dto.emis;

import com.proxiBanque.model.Advisor;

public class AdvisorDto {
    private Long id;
    private String name;
    private String firstName;
    private String phone;
    private String mail;

    protected AdvisorDto (){}

    public AdvisorDto(Advisor advisor){
        this.id=advisor.getId();
        this.name=advisor.getName();
        this.firstName=advisor.getFirstName();
        this.phone=advisor.getPhone();
        this.mail=advisor.getMail(); 
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    
}
