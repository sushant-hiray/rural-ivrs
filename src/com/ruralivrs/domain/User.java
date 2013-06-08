package com.ruralivrs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

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
	@NotEmpty(message="User Name field is mandatory.")
	private String firstName=null;

	@Column(name = "password")
	@NotEmpty(message="Password field is mandatory.")
	private String lastName=null;

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
