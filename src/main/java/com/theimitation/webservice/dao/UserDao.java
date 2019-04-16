package com.theimitation.webservice.dao;

import com.theimitation.webservice.model.User;

public interface UserDao {

	public User getUser(String userName) throws Exception;

	public String userRegistration(User user) throws Exception;

	public User save(User user);
}
