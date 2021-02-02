package com.amit.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.amit.model.Employee;

@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Employee.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Employee employee = (Employee) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "employee.userName.empty");
		if (employee.getUserName().length() < 2 || employee.getUserName().length() > 10) {
			errors.rejectValue("userName", "employee.userName.length");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "employee.name.empty");
		if (employee.getName().length() < 2 || employee.getName().length() > 20) {
			errors.rejectValue("name", "employee.name.length");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "employee.password.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfBirth", "employee.dateOfBirth.empty");
		if (!isValidDateOfBirthFormat(employee.getDateOfBirth())) {
			errors.rejectValue("dateOfBirth", "employee.dateOfBirth.format");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "employee.email.empty");
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(employee.getEmail());
		if (!matcher.matches()) {
			errors.rejectValue("email", "employee.email.format");
		}
	}

	private boolean isValidDateOfBirthFormat(String dateOfBirth) {
		try {
			String[] splittedDOB = dateOfBirth.split("/");
			if (splittedDOB.length != 3) {
				return false;
			}
			int month = Integer.parseInt(splittedDOB[0]);
			int date = Integer.parseInt(splittedDOB[1]);
			if (month < 1 || month > 12 || date < 1 || date > 31 || splittedDOB[2].length() != 4) {
				return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
