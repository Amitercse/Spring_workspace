package com.amit.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class Controller {
	
	@Autowired
	private Environment env;
	
	@Value("${spring.profiles.active}")
	private String activeProfile;

	@Autowired
	private Service service;
	
	public void performOperation()
	{
		System.out.println("active profile: "+activeProfile);
		service.performOperation();
	}
	
	/**
	 * Read data from properties file based on profile
	 */
	public void readProfileBasedProperties()
	{
		System.out.println(env.getProperty("db.url"));
		System.out.println(env.getProperty("db.user"));
		System.out.println(env.getProperty("db.password"));
	}
}
