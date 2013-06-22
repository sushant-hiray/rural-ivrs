package com.ruralivrs.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import org.hibernate.validator.constraints.NotEmpty;

//@Entity
//@Table(name = "admin_credentials")
public class User {

	//@Id
	//@GeneratedValue
	//@Column(name="admin_id")
	private int Id;
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	//@Column(name = "username")
	//@NotEmpty(message="User Name field is mandatory.")
	private String username=null;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//@Column(name = "password")
	//@NotEmpty(message="Password field is mandatory.")
	private String password=null;
	
	
	//@OneToOne(mappedBy="admin", cascade=CascadeType.ALL)
	private userRegistration userdetails;
	public userRegistration getUserdetails() {
		return userdetails;
	}

	public void setUserdetails(userRegistration userdetails) {
		this.userdetails = userdetails;
	}

	/*@Column(name = "gender")
	private String gender;

	@Column(name = "city")
	private String City;*/


/*	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}*/

}
