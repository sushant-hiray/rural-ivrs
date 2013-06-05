package com.ruralivrs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Admin_credentials")
public class User {

	@Id
	@GeneratedValue
	@Column(name="admin_id")
	private int Id;
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	@Column(name = "username")
	private String firstName;

	@Column(name = "password")
	private String lastName;

	/*@Column(name = "gender")
	private String gender;

	@Column(name = "city")
	private String City;*/

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

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
