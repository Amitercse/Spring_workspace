package com.amit.i18n;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {

	public static void main(String[] args) {
		ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
		Service service= context.getBean(Service.class);
		service.readMessages();
	}
}
