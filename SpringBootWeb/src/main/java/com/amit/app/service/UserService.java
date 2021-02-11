package com.amit.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amit.app.model.User;

@Service
public interface UserService {

	public void saveUserDetails(User user);
	
	public List<User> getAllUsers();
	
}
