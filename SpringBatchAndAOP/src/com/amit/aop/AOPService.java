package com.amit.aop;

import org.springframework.stereotype.Component;

@Component
public class AOPService {

	public void getDummyData()
	{
		System.out.println("Getting dummy data from AOP service");
	}
	
	public void saveData(String id, String name)
	{
		System.out.println("Saving mock data with id: "+ id +" and name: "+ name);
	}
	
	public void checkCompletionOrException() throws Exception
	{
		System.out.println("Dummy method which throws exception");
	//	throw new Exception("custom error");
	}
	
	public void checkAroundAdvice()
	{
		System.out.println("Service method to check around advice");
	}
}
