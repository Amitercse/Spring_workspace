package com.amit.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;

@ComponentScan(basePackages = "com.amit")
public class SpringTestConfig {

	@Bean
	public ResourceBundleMessageSource messageSource() {
	    ResourceBundleMessageSource source = new ResourceBundleMessageSource();
	    source.setBasenames("i18n/messages");
	    return source;
	}
}
