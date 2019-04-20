package com.theimitation.webservice.service;


import com.theimitation.webservice.dto.UserDto;
import com.theimitation.webservice.model.User;

public interface UserService {
	
	public UserDto authenticateUser(String userName,String password);
	public String userRegistration(User User);
	public void userActivationEmail(User user,String token);
}
