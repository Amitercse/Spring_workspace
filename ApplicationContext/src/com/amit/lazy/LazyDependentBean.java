package com.amit.lazy;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class LazyDependentBean implements BeanNameAware{

	@Override
	public String toString() {
		return "custom to string of lazy dependent bean";
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("Setting bean name for lazy dependent bean");
	}
}
