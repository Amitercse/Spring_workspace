package com.amit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amit.model.Employee;
import com.amit.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/getEmployee.view")
	public ModelAndView getEmployeeList()
	{
		ModelAndView modelAndView= new ModelAndView();
		List<Employee> empList= employeeService.getEmployeeList();
		modelAndView.setViewName("employeeDisplay");
		modelAndView.addObject("empList", empList);
		return modelAndView;
	}
}
