package com.ruralivrs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.NotEmpty;
//@Entity
//@Table(name = "admin_details")
public class userRegistration {
	//@Id
	//@GeneratedValue(generator="gen")
	//@GenericGenerator(name="gen", strategy="foreign", parameters=@Parameter(name="property", value="admin"))
	//@Column(name="admin_id")
	private long Id;
	
	//@Column(name="name")
	//@NotEmpty(message="Name field is mandatory.")
	private String adminName;
	
	//@Column(name="mobile_no")
	//@NotEmpty(message="Mobile No: field is mandatory.")
	private String mobileNumber;
	//@Column (name="email_id")
	//@NotEmpty(message="email is mandatory")
	private String emailId;
	
	//@OneToOne(optional=false,fetch = FetchType.LAZY)
    //@PrimaryKeyJoinColumn(name = "admin_id", referencedColumnName = "admin_id")
    private User admin;
	public User getAdmin() {
		return admin;
	}
	public void setAdmin(User admin) {
		this.admin = admin;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
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