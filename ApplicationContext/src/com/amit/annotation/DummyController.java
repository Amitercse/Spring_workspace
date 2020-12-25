package com.amit.annotation;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class DummyController {

	@Inject
	private DummyService dummyService;
	
	public void performOperation()
	{
		dummyService.performOperations();
	}
}
