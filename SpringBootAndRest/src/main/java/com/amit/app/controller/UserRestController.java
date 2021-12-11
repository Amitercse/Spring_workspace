package com.amit.app.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amit.app.model.User;
import com.amit.app.service.UserService;

@RestController
@RequestMapping("/users")
public class UserRestController {
	
	private static final String EMPTY_STRING= "";
	
	@Autowired
	private UserService userService;

	@GetMapping
	public List<User> getUserList(@RequestParam(required = false, name = "name") String name,
			@RequestParam(required = false, name = "email") String email) {
		if (name != null && !EMPTY_STRING.equals(name) && email != null && !EMPTY_STRING.equals(email)) {
			User user = userService.findByNameAndEmail(name, email);
			List<User> userList = new ArrayList<>();
			userList.add(user);
			return userList;
		}
		return userService.getAllUsers();
	}
	
	@PostMapping
	public String saveUser(@RequestBody User user)
	{
		userService.saveUserDetails(user);
		return "user saved successfully";
	}
	
	@GetMapping(value="/{userId}", produces={"application/json","application/xml"})
	public User getUserById(@PathVariable("userId") String userId)
	{
		return userService.findById(userId);
	}
	
	@GetMapping(value = "/dob")
	public List<User> findByDOBGreaterThan(@RequestParam("dob") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dob) {
		return userService.findByDOBGreaterThan(dob);
	}
}
