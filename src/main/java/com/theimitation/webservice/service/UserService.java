package com.theimitation.webservice.service;

import com.theimitation.webservice.dto.UserDto;

public interface UserService {
	
	public UserDto userAuthentication(String userName,String password);
	public String userRegistration();

}
