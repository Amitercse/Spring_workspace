package com.amit.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amit.app.model.User;
import com.amit.app.service.UserService;

@RestController
public class UserRestController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<User> getUserList()
	{
		return userService.getAllUsers();
	}
	
	@PostMapping("/users")
	public String saveUser(@RequestBody User user)
	{
		userService.saveUserDetails(user);
		return "user saved successfully";
	}
	
	@GetMapping(value="/users/{userId}", produces={"application/json","application/xml"})
	public User getUserById(@PathVariable("userId") String userId)
	{
		return userService.findById(userId);
	}
}
