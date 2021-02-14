package com.amit.app.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amit.app.model.User;

@Controller
public class UserController {
	
	@GetMapping(value = "/userDisplay.view")
	public ModelAndView getAllUsers()
	{
		ModelAndView modelAndView= new ModelAndView();	
		List<User> userList= getuserList();
		System.out.println(userList);
		modelAndView.setViewName("userDisplay");
		modelAndView.addObject("userList", userList);
		return modelAndView;
	}
	
	private List<User> getuserList()
	{
		User user1= new User();
		user1.setUserName("user1");
		user1.setName("First name");
		user1.setDateOfBirth(new Date());
		user1.setEmail("user1@gmail.com");
		user1.setPassword("12345");
		User user2= new User();
		user2.setUserName("user2");
		user2.setName("Second name");
		user2.setDateOfBirth(new Date());
		user2.setEmail("user2@gmail.com");
		user2.setPassword("12345");
		List<User> userList= new ArrayList<User>();
		userList.add(user1);
		userList.add(user2);
		return userList;
	}
}
