package com.amit.i18n;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class Service {

	@Autowired
	private MessageSource messageSource;
	
	public void readMessages()
	{
		Locale customLocale= new Locale("custom", "custom");
	//	Locale.setDefault(Locale.FRANCE);
	//	Locale.setDefault(customLocale);
		String message= messageSource.getMessage("app.message", null, Locale.getDefault());
		System.out.println(message);
		String greetingMessage= messageSource.getMessage("greeting.message", new Object[] {"ladies", "gentlemen"}, Locale.getDefault());
		System.out.println(greetingMessage);
	}
}
