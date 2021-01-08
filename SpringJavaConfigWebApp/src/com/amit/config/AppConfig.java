package com.amit.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.amit")
@EnableWebMvc
public class AppConfig {

	@Bean
    public MessageSource messageSource () {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:i18n/messages");
        return messageSource;
    }
	
	@Bean
	public ViewResolver viewResolver() {
	     InternalResourceViewResolver viewResolve = new InternalResourceViewResolver();
	     viewResolve.setPrefix("/views/");
	     viewResolve.setSuffix(".jsp"); 
	     return viewResolve;
	 }
}
