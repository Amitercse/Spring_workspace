package com.amit.spel;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.amit.spel")
@PropertySource("classpath:app.properties")
public class AppConfig {

}
