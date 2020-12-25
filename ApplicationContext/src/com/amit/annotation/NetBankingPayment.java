package com.amit.annotation;

import org.springframework.stereotype.Component;

@Component
public class NetBankingPayment implements PaymentService{

	@Override
	public void makePayment() {
		System.out.println("Making dummy payment using net banking");
	}

}
