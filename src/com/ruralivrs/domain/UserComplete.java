package com.ruralivrs.domain;

public class UserComplete {
	
	private User admin;
	public User getAdmin() {
		return admin;
	}
	public void setAdmin(User admin) {
		this.admin = admin;
	}
	public userRegistration getAdminDetails() {
		return adminDetails;
	}
	public void setAdminDetails(userRegistration adminDetails) {
		this.adminDetails = adminDetails;
	}
	private userRegistration adminDetails;
	private long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

}
