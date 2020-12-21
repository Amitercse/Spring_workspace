package com.amit.autowire;

public class Controller1 {

	private Service1 service;
	
	public Controller1(Service1 service) {
		this.service= service;
	}
	
	public void invokeService()
	{
		service.performOperation();
	}
}
