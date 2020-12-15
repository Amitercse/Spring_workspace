package com.amit.multipleConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigC {

	@Bean
	public ServiceC serviceC()
	{
		return new ServiceC();
	}
}
