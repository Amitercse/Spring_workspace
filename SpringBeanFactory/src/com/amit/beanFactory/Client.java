package com.amit.beanFactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client {
	
	public static void main(String[] args) {
		Resource res = new ClassPathResource("beanFactory-config.xml");
	    BeanFactory factory = new XmlBeanFactory(res);
	    Client client = new Client();
	//    client.getBeanViaConstructorInjection(factory);
	//    client.getBeanViaSetterInjection(factory);
	    // Use below code to use application context to read bean from xml
	    ApplicationContext context= new ClassPathXmlApplicationContext("beanFactory-config.xml");
	    Employee emp1= (Employee) context.getBean("employee1");
	    System.out.println(emp1);
	}
	
	private void getBeanViaConstructorInjection(BeanFactory factory)
	{
		// Getting bean initialized using parameterized constructor
		Employee emp1 = (Employee) factory.getBean("employee1");
	    System.out.println(emp1);
	    // Getting bean initialized using no-arg constructor
	    Employee emp2 = (Employee) factory.getBean("employee2");
	    Address address= (Address) factory.getBean("address");
	    emp2.setEmployeeId(2);
	    emp2.setEmployeeName("employee 2");
	    emp2.setDepartment("HR department");
	    emp2.setAddress(address);
	    System.out.println(emp2); 
	    // Accessing bean having multiple parameterized constructor injections
	    Employee emp3 = (Employee) factory.getBean("employee3");
	    System.out.println(emp3);  
	}
	
	private void getBeanViaSetterInjection(BeanFactory factory)
	{
		// Getting bean initialized via setter injection
	    Employee emp4 = (Employee) factory.getBean("employee4");
	    System.out.println(emp4);
	}
}
