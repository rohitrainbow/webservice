package com.theimitation.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.theimitation.webservice.dto.Login;
import com.theimitation.webservice.dto.UserDto;
import com.theimitation.webservice.model.User;
import com.theimitation.webservice.security.Authentication;
import com.theimitation.webservice.service.UserService;

@RestController
@CrossOrigin(origins = "http://20.198.10.4:8086")
public class UserController {

	@Autowired
	Authentication authentication;

	@Autowired
	UserService userService;

	@Autowired
	UserDto userDto;

	@RequestMapping(method = RequestMethod.POST, value = "/users/authenticate")
	public UserDto login(@RequestBody Login login) {
		userDto.setToken(null);
		userDto.setMessage("Invalid Credentials!!");
		if (userService.userAuthentication(login.getUsername(), login.getPassword()) != null)
			userDto = userService.userAuthentication(login.getUsername(), login.getPassword());
		if (userService.userAuthentication(login.getUsername(), login.getPassword()) != null) {
			userDto.setToken(authentication.generateToken());
		}

		return userDto;
	}
}
