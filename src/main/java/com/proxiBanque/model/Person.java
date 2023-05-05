package com.proxiBanque.model;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass 
public class Person {
    private String mail;
	private String password;
    protected Person() {
    }

    public Person(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }
    
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    
}
