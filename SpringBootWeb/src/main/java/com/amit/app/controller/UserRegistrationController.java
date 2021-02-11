package com.amit.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.amit.app.model.User;
import com.amit.app.service.UserService;

@Controller
public class UserRegistrationController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/adminRegisterUser.view")
	public String getRegistrationView(Model model)
	{
		User user= new User();
		model.addAttribute("user", user);
		return "userRegistration";
	}
	
	@PostMapping("/adminRegister.view")
	public String registerUser(@ModelAttribute("user") @Validated User user, BindingResult bindingResult, Model model)
	{
		if (bindingResult.hasErrors()) {
			return "userRegistration";
		}
		System.out.println("user details: "+ user);
		userService.saveUserDetails(user);
		return "registrationSuccess";
	}
}
