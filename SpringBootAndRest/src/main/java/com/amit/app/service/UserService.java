package com.amit.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.amit.app.model.User;

@Service
public interface UserService {

	public void saveUserDetails(User user);
	
	public List<User> getAllUsers();
	
	public User findById(String userId);
	
	public User findByNameAndEmail(String name, String email);
	
	public List<User> findByDOBGreaterThan(Date dateOfBirth);
	
}
