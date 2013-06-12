package com.ruralivrs.dao;

import java.util.List;
import java.util.ListIterator;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ruralivrs.domain.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public String saveUser(User user) {
		
		//sessionfactory.getCurrentSession().saveOrUpdate(user);
		
		List<User> l = this.getUser();
		//l.contains(user);
		//Iterator<User> it = (Iterator<User>) l;
		//User u=(User) it;
		ListIterator<User> itr=l.listIterator();
		String success="fail";
		while(itr.hasNext()){
			User u = (User)itr.next();
			if(u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword()))
			success="successful";
		}
		return success;
		
	}
	@Override
	public void registerUser(User user){
		sessionfactory.getCurrentSession().saveOrUpdate(user);
	}
	@Override
	public List<User> getUser() {
		@SuppressWarnings("unchecked")
		List<User> userlist = sessionfactory.getCurrentSession()
				.createCriteria(User.class).list();
		return userlist;
	}
	
	@Override
	public boolean checkUsername(String user) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public User getUserfromId(long id) {
		List<User> l = this.getUser();
		ListIterator<User> itr=l.listIterator();
		while(itr.hasNext()){
			User u = (User)itr.next();
			if(u.getId()==id){
				return u;
			}
			
		}
		return null;
	}

}
