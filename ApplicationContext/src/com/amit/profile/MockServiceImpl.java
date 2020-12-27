package com.amit.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
public class MockServiceImpl implements Service {

	@Override
	public void performOperation() {
		// Mocking the service for testing
		System.out.println("Performing test operation by mocking the service");
	}

}
