package com.ruralivrs.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
	@Length(max=10,min=10,message="Phone number is not valid. Should be of length 10.")
    @NotEmpty(message="Phone field is mendatory.") @NumberFormat(style= Style.NUMBER)
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