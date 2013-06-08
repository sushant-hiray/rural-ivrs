package com.ruralivrs.service;

import java.util.List;

import com.ruralivrs.domain.User;

public interface UserService {
	public String addUser(User user);
	public void addNewuser(User user);
	public boolean checkUser(String user);
	public List<User> getUser();
}
