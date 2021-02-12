package com.amit.app.service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	@Override
	public User findById(String userId) {
		Optional<User> user = userDao.findById(userId);
		if (user.isPresent()) {
			return user.get();
		} else {
			return new User();
		}
	}

}
