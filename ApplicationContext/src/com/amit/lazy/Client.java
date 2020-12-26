package com.amit.lazy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {

	public static void main(String[] args) {
		ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("App config loaded");
		// Get beans from context
		LazyBean lazyBean= context.getBean(LazyBean.class);
		System.out.println(lazyBean);
		System.out.println(lazyBean.getLazyDependentBean());
	}
}
