package com.amit.app;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.amit.model.Employee;
import com.amit.service.EmployeeService;

@SpringBootApplication
@ComponentScan(basePackages = "com.amit")
public class Client {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(Client.class, args);
		EmployeeService service= context.getBean(EmployeeService.class);
		service.getData();
		List<Employee> employeeList= service.getEmployees();
		System.out.println("employees list: "+employeeList);
	}
}
