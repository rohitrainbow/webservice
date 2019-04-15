package com.theimitation.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.theimitation.webservice.dto.Login;
import com.theimitation.webservice.dto.UserDto;
import com.theimitation.webservice.security.Authentication;

@RestController
@CrossOrigin(origins = "http://20.198.10.4:8086")
public class UserController {

	@Autowired
	Authentication authentication;
	
	@Autowired
	UserDto user;

	@RequestMapping(method = RequestMethod.POST, value = "/users/authenticate")
	public UserDto login(@RequestBody Login login) {
		user.setId(545);
		user.setToken(null);
		user.setMessage("Invalid Credentials!!");
		if (login.getUsername().equals("theimitation") && login.getPassword().equals("juna283")) {
			user.setToken(authentication.generateToken());
		}

		return user;
	}
}
