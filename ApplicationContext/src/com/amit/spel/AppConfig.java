package com.amit.spel;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@ComponentScan(basePackages = "com.amit.spel")
@PropertySource("classpath:app.properties")
/* Load multiple properties files
 * @PropertySources({
	@PropertySource("classpath:env.properties"),
	@PropertySource("classpath:env2.properties")
})*/
public class AppConfig {

}
