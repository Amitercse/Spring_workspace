package com.amit.spel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component("util")
public class Util {

	public int calculateAge(String dateOfBrith) throws ParseException
	{
		Date dob= new SimpleDateFormat("yyyy-mm-dd").parse(dateOfBrith);
		int birthYear= dob.getYear();
		int currentYear= new Date().getYear();
		return currentYear- birthYear;
	}
}
