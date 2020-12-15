package com.amit.multipleConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {

	public static void main(String[] args) {
		ApplicationContext context= new AnnotationConfigApplicationContext(ConfigA.class, ConfigB.class);
		ServiceA serviceA= (ServiceA) context.getBean("serviceA");
		serviceA.performOperation();
		ServiceB serviceB= (ServiceB) context.getBean("serviceB");
		serviceB.performOperation();
	}
}
