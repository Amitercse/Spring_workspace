package com.amit.i18n;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
		ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
		Service service= context.getBean(Service.class);
		service.readMessages();
		// Read i18n properties from xml
		ApplicationContext xmlContext= new ClassPathXmlApplicationContext("applicationContext.xml");
		MessageSource messageSource= (MessageSource) xmlContext.getBean("messageXmlSource");
		String message= messageSource.getMessage("app.message", null, Locale.getDefault());
		System.out.println("message from client: "+message);
	}
}
