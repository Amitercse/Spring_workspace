package com.amit.appContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.amit.appContext")
public class AppConfig {
	
	/*
	 * Use @Bean annotation to instantiate spring bean. If we are using @Bean
	 * annotation then no need of @Component annotation.
	 */
	@Bean
	public Customer customer()
	{
		// Here even we can pass dynamic values to constructor
		return new Customer(1,"customer1");
	}
	
}
