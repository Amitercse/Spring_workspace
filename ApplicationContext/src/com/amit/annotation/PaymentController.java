package com.amit.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PaymentController {
	
	@Autowired
	@Qualifier("netBankingPayment")
	private PaymentService paymentService;

	public void makePayment()
	{
		paymentService.makePayment();
	}
}
