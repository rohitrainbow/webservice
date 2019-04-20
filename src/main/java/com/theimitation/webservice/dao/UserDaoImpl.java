package com.theimitation.webservice.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.theimitation.webservice.model.User;
import com.theimitation.webservice.repository.UserRepository;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	EntityManager entityManager;

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public User getUser(String email) throws Exception {
		try {
			List<User> results = new ArrayList<User>();
			results = entityManager.createQuery("SELECT user FROM User user where LOWER(user.email) = :email")
					.setParameter("email", email.toLowerCase()).getResultList();
			if (results.isEmpty())
				throw new Exception("USER_DOES_NOT_EXIST");
			return results.get(0);
		} catch (Exception e) {
			if (e.getMessage().equals("USER_DOES_NOT_EXIST"))
				throw new Exception("USER_DOES_NOT_EXIST");
		}
		return null;
	}

	@Override
	public String userRegistration(User user) throws Exception {
		// TODO Auto-generated method stub
		try {
			getUser(user.getEmail());
			return "USER_EXIST";
		} catch (Exception e) {
			if (e.getMessage().equals("USER_DOES_NOT_EXIST")) {
				save(user);
				return "REGISTRATION_SUCCESS";
			}
			throw e;
		}
	}

}
