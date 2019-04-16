package com.theimitation.webservice.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.theimitation.webservice.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public User userAuthentication(String userName, String password) {
		List<User> results = new ArrayList<User>();
		results = entityManager
				.createQuery("SELECT user FROM User user where user.userName = :userName and user.password=:password")
				.setParameter("userName", userName).setParameter("password", password).getResultList();
		if (results.isEmpty())
			return null;
		return results.get(0);
	}

	@Override
	public String userRegistration() {
		// TODO Auto-generated method stub
		return null;
	}

}
