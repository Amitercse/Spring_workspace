package com.amit.multipleConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ConfigC.class)
public class ConfigA {

	@Autowired
	ConfigC configC;
	
	@Bean
	public ServiceA serviceA()
	{
		return new ServiceA(configC.serviceC());
	}
}
