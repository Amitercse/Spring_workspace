package com.amit.annotation;

import org.springframework.stereotype.Component;

@Component
public interface PaymentService {

	public void makePayment();
}
