package com.amit.multipleConfig;

public class ServiceA {
	
	private ServiceC serviceC;
	
	public ServiceA(ServiceC serviceC) {
		this.serviceC= serviceC;
	}

	public void performOperation()
	{
		serviceC.performOperation();
		System.out.println("Perform operation for service A");
	}
}
