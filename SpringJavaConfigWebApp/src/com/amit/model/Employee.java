package com.amit.model;

import org.springframework.stereotype.Component;

@Component
public class Employee {

	private String userName;
	private String name;
	private String password;
	private String dateOfBirth;
	private String email;
	private String department;
	
	/**
	 * Default constructor
	 */
	public Employee() {
		super();
	}
	/**
	 * @param userName
	 * @param password
	 * @param dateOfBirth
	 * @param email
	 * @param department
	 */
	public Employee(String userName, String name, String password, String dateOfBirth, String email, String department) {
		super();
		this.userName = userName;
		this.name = name;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.department = department;
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
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
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
	@Override
	public String toString() {
		return "Employee [userName=" + userName + ", name=" + name + ", password=" + password + ", dateOfBirth="
				+ dateOfBirth + ", email=" + email + ", department=" + department + "]";
	}
}
