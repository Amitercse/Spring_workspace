package com.amit.jdbc;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	
	static Controller controller;
	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		controller= context.getBean(Controller.class);
	//	saveUserData();
	//	updateUserData();
		getUserById();
		getUserList();
		getUserName();
		groupUsersByLoc();
	//	deleteUserById();
	//	saveUserDataWithNamedParams();
	//	saveUserDataWithNamedBeanParams();
	//	saveUserWithSimpleJDBCInsert();
	}
	
	private static void saveUserData()
	{
		controller.saveUserData(4, "User 4", "01/04/1992", "Bangalore");
	}
	
	private static void updateUserData()
	{
		controller.updateUserData(4, "User 4", "01/03/1993", "Chennai");
	}
	
	private static void getUserById()
	{
		User user= controller.getUserById(1);
		System.out.println(user);
	}
	
	private static void getUserList()
	{
		List<User> userList= controller.getUsersList();
		System.out.println(userList);
	}
	
	private static void getUserName()
	{
		List<String> userNames= controller.getUsersNames();
		System.out.println(userNames);
	}
	
	private static void deleteUserById()
	{
		controller.deleteUserById(4);
	}
	
	private static void groupUsersByLoc()
	{
		Map<String, List<User>> userLocationMap= controller.userListGroupedByLoc();
		for(String key: userLocationMap.keySet())
		{
			System.out.println("location: "+ key);
			System.out.println("Employees list:\n"+userLocationMap.get(key));
			System.out.println("\n");
		}
	}
	
	private static void saveUserDataWithNamedParams()
	{
		controller.saveUserWithNamedJDBCParams(5, "User 5", "02/04/1992", "Chennai");
	}
	
	private static void saveUserDataWithNamedBeanParams()
	{
		controller.saveUserWithNamedJDBCBeanParams(6, "User 6", "02/04/1993", "Hyderabad");
	}
	
	private static void saveUserWithSimpleJDBCInsert()
	{
		controller.saveUserWithSimpleJDBCInsert(7, "User 7", "03/03/1993", "Hyderabad");
	}
}
