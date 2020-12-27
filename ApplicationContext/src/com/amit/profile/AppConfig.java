package com.amit.profile;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = "com.amit.profile")
@PropertySource("classpath:app-${spring.profiles.active}.properties")
public class AppConfig {

}
