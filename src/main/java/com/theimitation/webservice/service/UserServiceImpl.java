package com.theimitation.webservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.theimitation.webservice.dao.UserDao;
import com.theimitation.webservice.dto.UserDto;
import com.theimitation.webservice.model.User;
import com.theimitation.webservice.security.Authentication;
import com.theimitation.webservice.util.EmailUtil;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	Authentication authentication;

	@Autowired
	EmailUtil emailUtil;

	@Autowired
	UserDao userDao;

	@Autowired
	UserDto userDto;

	@Override
	public UserDto authenticateUser(String userName, String password) {
		User user = new User();
		try {
			user = userDao.getUser(userName);
			if (!password.equals(user.getPassword())) {
				throw new Exception("INVALID_CREDENTIALS");
			}
			userDto.setId(user.getId());
			userDto.setUserName(user.getEmail());
			userDto.setPassword(user.getPassword());
			userDto.setFirstName(user.getFirstName());
			userDto.setToken(authentication.generateToken());
			userDto.setLastName(user.getLastName());
		} catch (Exception e) {
			if (e.getMessage().equals("USER_DOES_NOT_EXIST")) {
				userDto.setToken(null);
				userDto.setMessage("User account does not Exist!!");
			} else if (e.getMessage().equals("INVALID_CREDENTIALS")) {
				userDto.setToken(null);
				userDto.setMessage("Incorrect username or password");
			}
		}
		return userDto;

	}

	@Override
	public String userRegistration(User user) {
		// TODO Auto-generated method stub
		String status = "";
		try {
			status = userDao.userRegistration(user);
			user.setVerified(false);
			
			if (status.equals("REGISTRATION_SUCCESS"))
			{
				String token = authentication.generateToken();
				userActivationEmail(user,token);
				user.setEmailToken(token);
				status = "User Registered Successfully";
			}
			else if (status.equals("USER_EXIST"))
			{
				status = "User Name Exist.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public void userActivationEmail(User user,String token) {
		String subject = "User account activation The Imitation Store";
		String url = "http://www.theimitation.store?token=" + token;
		String body = "<h1>Hi " + user.getFirstName() + ",</h1>";
		body = body
				+ "<p>We have recieved a registration request for The Imitation Store Account.</p><p>Please use the below link to activate your account,</p>";
		body = body + "<center><a href=\"" + url
				+ "\" style=\"text-decoration: none;\">Activate</a></center>";
		System.out.println(body);
		emailUtil.sendEmail(null, user.getEmail(), subject, body);
	}
}
