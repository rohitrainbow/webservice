package com.theimitation.webservice.dao;

import com.theimitation.webservice.model.User;

public interface UserDao {

	public User userAuthentication(String userName,String password);
	public String userRegistration();
}
