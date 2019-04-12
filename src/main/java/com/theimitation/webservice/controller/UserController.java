package com.theimitation.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.theimitation.webservice.dto.Login;
import com.theimitation.webservice.model.User;
import com.theimitation.webservice.security.Authentication;

@RestController
@CrossOrigin(origins = "http://20.198.10.4:8086")
public class UserController {
	
	@Autowired
	Authentication authentication;
	
	
	@RequestMapping(method = RequestMethod.POST, value ="/users/authenticate")
	public User login(@RequestBody Login login)
	{
		System.out.println("Called");
		return authentication.generateToken();
	}
}
