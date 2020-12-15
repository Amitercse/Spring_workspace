package com.amit.fieldInjection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import com.amit.serviceProvider.EmailServiceProvider;
import com.amit.serviceProvider.GmailServiceProvider;
import com.amit.serviceProvider.OutlookServiceProvider;

public class Client {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		EmailService emailService= new EmailService();
		Field[] fields= EmailService.class.getDeclaredFields();
		for(Field field: fields)
		{
			if(field.isAnnotationPresent(Dependency.class))
			{
				field.setAccessible(true);
				EmailServiceProvider serviceProvider= new GmailServiceProvider();
				field.set(emailService, serviceProvider);
			}
		}
		emailService.sendMail("abc@gmail.com", "Test message for field injection");
	}
}
