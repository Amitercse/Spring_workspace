package com.amit.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amit.app.model.User;
import com.amit.app.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping(value = "/userDisplay.view")
	public ModelAndView getAllUsers()
	{
		ModelAndView modelAndView= new ModelAndView();
		List<User> userList= userService.getAllUsers();
		modelAndView.setViewName("userDisplay");
		modelAndView.addObject("userList", userList);
		return modelAndView;
	}
}
