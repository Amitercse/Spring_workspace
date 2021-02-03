package com.amit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amit.model.Employee;
import com.amit.service.EmployeeService;
import com.amit.validator.EmployeeValidator;

@Controller
public class RegistrationController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private Employee employee;
	
	@Autowired
	private EmployeeValidator validator;

	@RequestMapping("/adminRegisterEmployee.view")
	public String registrationView(Model model)
	{
		model.addAttribute("emp", employee);
		List<String> deptList= employeeService.getDepartmentList();
		System.out.println(deptList);
		model.addAttribute("deptList", deptList);
		return "employeeRegistration";
	}
	
	@RequestMapping("/adminRegister.view")
	public String registerEmployee(@ModelAttribute("emp") @Validated Employee employee, BindingResult bindingResult,
			@RequestParam("dummyParam") String dummyParam, Model model) {
	//	validator.validate(employee, bindingResult);
		if(bindingResult.hasGlobalErrors())
		{
			bindingResult.rejectValue("password", null, bindingResult.getGlobalErrors().get(0).getDefaultMessage());
		} 
		if (bindingResult.hasErrors()) {
			List<String> deptList= employeeService.getDepartmentList();
			model.addAttribute("deptList", deptList);
			return "employeeRegistration";
		}
		System.out.println("Dummy param value: " + dummyParam);
		employeeService.saveEmployeeData(employee);
		return "registrationSuccess";
	}
}
