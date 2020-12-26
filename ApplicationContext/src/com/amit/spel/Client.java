package com.amit.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
		ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
		User user= context.getBean(User.class);
		System.out.println(user);
		
		// Reading bean from xml
	/*	ApplicationContext xmlContext= new ClassPathXmlApplicationContext("applicationContext.xml");
		XmlUser xmlUser= (XmlUser) xmlContext.getBean("xmlUser1");
		System.out.println(xmlUser);  */
	}
}
