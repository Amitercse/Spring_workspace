package com.amit.aop;

import org.springframework.stereotype.Component;

@Component
public class MockAOPService {

	public void getMockData()
	{
		System.out.println("Getting data from mock AOP service");
	}
}
