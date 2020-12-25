package com.amit.annotation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class CardPayment implements PaymentService {

	@Override
	public void makePayment() {
		System.out.println("Making dummy payment using card");
	}

}
