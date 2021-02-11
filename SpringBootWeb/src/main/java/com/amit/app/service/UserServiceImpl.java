package com.amit.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amit.app.dao.UserDao;
import com.amit.app.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;

	@Override
	public void saveUserDetails(User user) {
		userDao.save(user);
	}

}
