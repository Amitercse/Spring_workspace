package com.amit.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class ServiceImpl implements Service {

	@Override
	public void performOperation() {
		// Here we can write code for getting data from DB
		System.out.println("Performing operation for dev service");
	}

}
