package com.amit.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.amit.bean")
public class BeanConfig {

	@Bean(initMethod="init",destroyMethod="destroy")
	public User user()
	{
		return new User();
	}
	
	@Bean
	public ContactDetails contactDetails()
	{
		return new ContactDetails();
		
	}
}
