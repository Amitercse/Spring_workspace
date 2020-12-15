package com.amit.multipleConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigB {

	@Bean
	public ServiceB serviceB()
	{
		return new ServiceB();
	}
}
