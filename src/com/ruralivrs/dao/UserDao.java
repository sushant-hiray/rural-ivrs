package com.ruralivrs.dao;

import java.util.List;

import com.ruralivrs.domain.User;

public interface UserDao {
public String saveUser ( User user );
public void registerUser(User user);
public List<User> getUser();
}
