package com.amit.appContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.amit")
public class AppConfig {
	
	/*
	 * Use @Bean annotation to instantiate spring bean. If we are using @Bean
	 * annotation then no need of @Component annotation.
	 */
/*	@Bean
	public Employee employeeBean()
	{
		return new Employee(11,"emp2","HR", empAddress());
	}
	
	@Bean
	public Address empAddress()
	{
		return new Address(111, "locality 1", "city 1");
	}
	*/
}
