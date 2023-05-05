package com.proxiBanque.dto.received;

import com.proxiBanque.model.Advisor;

public class UserDto {
	private long id;
	private String name;
	private String firstName;
	private String phone;
	private String mail;
	private String password;

	protected UserDto() {
	}

	public UserDto(Advisor advisor) {
		this.id = advisor.getId();
		this.name = advisor.getName();
		this.firstName = advisor.getFirstName();
		this.phone = advisor.getPhone();
		this.mail = advisor.getMail();
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
