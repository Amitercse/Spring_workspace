package com.amit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.amit.model.Employee;
import com.amit.service.EmployeeService;

@Controller
public class RegistrationController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private Employee employee;

	@RequestMapping("/registerEmployee.view")
	public String registrationView(Model model)
	{
		model.addAttribute("emp", employee);
		List<String> deptList= employeeService.getDepartmentList();
		System.out.println(deptList);
		model.addAttribute("deptList", deptList);
		return "employeeRegistration";
	}
	
	@RequestMapping("/register.view")
	public String registerEmployee(@ModelAttribute("emp") Employee employee)
	{
		employeeService.saveEmployeeData(employee);
		return "registrationSuccess";
	}
	
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
