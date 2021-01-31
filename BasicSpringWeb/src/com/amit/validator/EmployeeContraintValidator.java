package com.amit.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.amit.model.Employee;

public class EmployeeContraintValidator implements ConstraintValidator<EmployeeConstraint, Employee> {

	@Override
	public boolean isValid(Employee employee, ConstraintValidatorContext context) {
		// write logic to validate employee object here.
		if(employee.getPassword().contains(employee.getUserName())
				|| employee.getPassword().contains(employee.getName())) {
			System.out.println("employee validation errors exist");
			return false;
		} else {
			return true;
		}
	}

}
