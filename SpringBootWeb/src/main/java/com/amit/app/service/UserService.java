package com.amit.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.amit.app.model.User;

@Service
public interface UserService {

	public void saveUserDetails(User user);
	
	public List<User> getAllUsers();
	
	public User findById(String userId);
	
}
