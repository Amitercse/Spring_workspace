package com.amit.app.service;

import org.springframework.stereotype.Service;

import com.amit.app.model.User;

@Service
public interface UserService {

	public void saveUserDetails(User user);
	
}
