package com.ruralivrs.domain;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
@Entity
@Table(name = "Admin_details")
public class userRegistration {
	@Id
	@GeneratedValue
	@Column(name="admin_id")
	private long Id;
	
	@Column(name="name")
	@NotEmpty(message="Name field is mandatory.")
	private String adminName;
	
	@Column(name="mobile_no")
	@NotEmpty(message="Name field is mandatory.")
	private String mobileNumber;
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


}