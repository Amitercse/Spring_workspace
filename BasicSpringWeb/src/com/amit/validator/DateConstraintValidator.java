package com.amit.validator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateConstraintValidator implements ConstraintValidator<DateConstraint, String>{

	private String dateFormat;
	@Override
    public void initialize(DateConstraint dateConstraint) {
		dateFormat= dateConstraint.dateFormat();
    }
	
	@Override
	public boolean isValid(String dateField, ConstraintValidatorContext context) {
		DateFormat format = new SimpleDateFormat(dateFormat);
		try {
			format.parse(dateField);
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
