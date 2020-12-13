package com.amit.fieldInjection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Client {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		EmailService emailService= new EmailService();
		Field[] fields= EmailService.class.getDeclaredFields();
		for(Field field: fields)
		{
			if(field.isAnnotationPresent(Dependency.class))
			{
				field.setAccessible(true);
				Object dependencyInjection= field.getType().getConstructor(new Class[] {}).newInstance();
				field.set(emailService, dependencyInjection);
			}
		}
		emailService.sendMail("abc@gmail.com", "Test message for field injection");
	}
}
