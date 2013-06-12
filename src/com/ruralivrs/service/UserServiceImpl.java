package com.ruralivrs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ruralivrs.dao.UserDao;
import com.ruralivrs.domain.User;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public String addUser(User user) {
		return userDao.saveUser(user);
	}
	@Override
	public void addNewuser(User user){
		userDao.registerUser(user);
	}
	@Override
	public List<User> getUser() {
		return userDao.getUser();
	}
	@Override
	public boolean checkUser(String user) {
		return userDao.checkUsername(user);
	}
	@Override
	public User getUserfromId(long id) {
		
		return userDao.getUserfromId(id);
	}

}
