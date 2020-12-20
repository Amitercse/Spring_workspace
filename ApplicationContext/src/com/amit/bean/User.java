package com.amit.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class User implements BeanNameAware, BeanFactoryAware, InitializingBean {

	private int id;
	private String name;
	private String beanName;
	@Autowired
	private ContactDetails contactDetails;
	
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
	
	/**
	 * @return the contactDetails
	 */
	public ContactDetails getContactDetails() {
		return contactDetails;
	}
	/**
	 * @param contactDetails the contactDetails to set
	 */
	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}
	@Override
	public void setBeanName(String name) {
		System.out.println("bean name: "+ name);
		this.beanName= name;
	}
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println(beanFactory.getType(this.getBeanName()));
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("After properties set invoked");
	}
	
	public void init()
	{
		System.out.println("invoking init method of class");
	}
	
	public void destroy()
	{
		System.out.println("invoking destroy method of class");
	}
	
//	@PostConstruct
	public void postConstructMethod()
	{
		System.out.println("Invoked post construction for a bean");
	}
	
//	@PreDestroy
	public void preDestroyMethod()
	{
		System.out.println("Invoked pre destroy for a bean");
	}
}
