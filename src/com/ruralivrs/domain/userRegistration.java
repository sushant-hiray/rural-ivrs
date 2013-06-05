package com.ruralivrs.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Admin_details")
public class userRegistration {
	@Id
	@GeneratedValue
	@Column(name="admin_id")
	private long Id;
	@Column(name="name")
	private String adminName;
	@Column(name="mobile_no")
	private long mobileNumber;
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
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


}