package com.amit.autowire;

public class Controller {

	private Service serviceBean;
	
	public void invokeService()
	{
		serviceBean.performOperation();
	}
	
	public void setServiceBean(Service service)
	{
		this.serviceBean= service;
	}
}
