package com.ruralivrs.dao;

import com.ruralivrs.domain.userRegistration;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository("userRegistrationDao")
public class userRegistrationDaoImpl implements userRegistrationDao {
	
	@Autowired
	private SessionFactory sessionfactory;
	@Override
	public void saveUser(userRegistration user) {
		sessionfactory.getCurrentSession().saveOrUpdate(user);
	}

}
