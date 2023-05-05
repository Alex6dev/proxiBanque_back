package com.proxiBanque.dto.emis;

import com.proxiBanque.model.Advisor;
import com.proxiBanque.model.ERole;
import com.proxiBanque.model.Manager;
import com.proxiBanque.model.Person;



public class UserDto {
	private long id;
	private String name;
	private String firstName;
	private String phone;
	private String mail;
	private ERole typeUser;

	protected UserDto() {}
	
	public UserDto(Person person) {
		if(person instanceof Advisor advisor){
			this.id=advisor.getId();
			this.name=advisor.getName();
			this.firstName=advisor.getFirstName();
			this.phone=advisor.getPhone();
			this.mail=advisor.getMail();
			this.typeUser=ERole.ADVISOR;
		}else if(person instanceof Manager manager){
			this.id=manager.getId();
            this.name=manager.getName();
            this.firstName=manager.getFirstName();
            this.phone=manager.getPhone();
            this.mail=manager.getMail();
			this.typeUser=ERole.MANAGER;
		}
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

	public ERole getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(ERole typeUser) {
		this.typeUser = typeUser;
	}
	
}
