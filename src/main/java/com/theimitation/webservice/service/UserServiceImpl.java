package com.theimitation.webservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.theimitation.webservice.dao.UserDao;
import com.theimitation.webservice.dto.UserDto;
import com.theimitation.webservice.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	UserDto userDto;

	@Override
	public String userRegistration() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto userAuthentication(String userName, String password) {
		User user=new User();
		user=userDao.userAuthentication(userName, password);
		if(user==null)
			return null;
		userDto.setId(user.getId());
		userDto.setFirstName(user.getFirstName());
		return userDto;
		
	}
}
