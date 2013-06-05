package com.ruralivrs.service;

import com.ruralivrs.dao.userRegistrationDao;
import com.ruralivrs.domain.userRegistration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class userRegistrationServiceImpl implements userRegistrationService {
	
	@Autowired
	userRegistrationDao userRegistrationDao;
	
	@Override
	public void addUser(userRegistration user) {
		userRegistrationDao.saveUser(user);
	}

}
