package com.amit.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class User implements BeanNameAware, BeanFactoryAware {

	private int id;
	private String name;
	private String beanName;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the bean name
	 */
	public String getBeanName() {
		return beanName;
	}
	
	@Override
	public void setBeanName(String name) {
		System.out.println("bean name: "+ name);
		this.beanName= name;
	}
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		
	}
}
