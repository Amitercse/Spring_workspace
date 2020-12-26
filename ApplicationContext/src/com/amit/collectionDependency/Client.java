package com.amit.collectionDependency;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

	public static void main(String[] args) {
		ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
		Department dept= context.getBean(Department.class);
		System.out.println(dept);
		System.out.println(dept.getStudentList());
		System.out.println(dept.getStudentMap()); 
		// Reading collection dependency from xml config
		ApplicationContext xmlContext= new ClassPathXmlApplicationContext("applicationContext.xml");
		XMLConfigDept xmlConfigDept= (XMLConfigDept) xmlContext.getBean("xmlConfigDept");
		System.out.println(xmlConfigDept.getDummyList());
		System.out.println(xmlConfigDept.getDummyMap());
		System.out.println(xmlConfigDept.getStudentList());
		System.out.println(xmlConfigDept.getStudentMap());  
	}
}
