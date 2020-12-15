package com.amit.appContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.amit")
public class AppConfig {
	
	@Bean
	public Employee employeeBean()
	{
		return new Employee();
	}
}
