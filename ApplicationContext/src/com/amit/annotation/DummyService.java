package com.amit.annotation;

import javax.inject.Named;

@Named
public class DummyService {

	public void performOperations()
	{
		System.out.println("Performing dummy operations");
	}
}
