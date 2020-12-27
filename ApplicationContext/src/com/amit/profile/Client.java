package com.amit.profile;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
		System.setProperty("spring.profiles.active", "dev");
		ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
		Controller controller= context.getBean(Controller.class);
		controller.performOperation();
		// Reading beans profile from xml
	/*	ApplicationContext xmlContext= new ClassPathXmlApplicationContext("beanProfile.xml");
		XmlController xmlController= (XmlController) xmlContext.getBean("xmlController");
		xmlController.performOperation(); */
		
		
		// Reading profile based properties
	//	controller.readProfileBasedProperties();
	//	xmlController.readProfileBasedProperties();
	}
}
