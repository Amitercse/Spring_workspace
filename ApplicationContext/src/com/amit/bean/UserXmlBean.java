package com.amit.bean;

import org.springframework.beans.factory.annotation.Required;

/**
 * Bean class to be managed by spring xml configuration.
 * @author Amit sharma
 */
public class UserXmlBean {

	private String userId;
	private String userName;
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void init()
	{
		System.out.println("invoking custom init for xml bean");
		this.userId= "default id";
		this.userName= "default name";
	}
	
	public void destroy()
	{
		System.out.println("invoking custom destroy for xml bean");
	}
	
	@Override
	public String toString() {
		return "UserXmlBean [userId=" + userId + ", userName=" + userName + "]";
	}
}
