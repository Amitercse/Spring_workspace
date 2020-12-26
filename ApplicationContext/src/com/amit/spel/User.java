package com.amit.spel;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("user")
public class User {

	@Value("Rod")
	private String firstName;
	@Value("Jhonson")
	private String lastName;
	@Value("#{user.firstName.concat(' ').concat(user.lastName)}")
	private String fullName;
	@Value("1993-03-21")
	private String dateOfBirth;
	@Value("#{util.calculateAge(user.dateOfBirth)}")
	private int age;
	@Value("#{user.age ge 18}")
	private boolean isBooleanAge;
	@Value("#{15 + 20}")
	private int dummyValue;
	@Value("${app.property1}")
	private String propertyName;

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
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
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the isBooleanAge
	 */
	public boolean isBooleanAge() {
		return isBooleanAge;
	}

	/**
	 * @param isBooleanAge the isBooleanAge to set
	 */
	public void setBooleanAge(boolean isBooleanAge) {
		this.isBooleanAge = isBooleanAge;
	}

	/**
	 * @return the dummyValue
	 */
	public int isDummyValue() {
		return dummyValue;
	}

	/**
	 * @param dummyValue the dummyValue to set
	 */
	public void setDummyValue(int dummyValue) {
		this.dummyValue = dummyValue;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", fullName=" + fullName + ", dateOfBirth="
				+ dateOfBirth + ", age=" + age + ", isBooleanAge=" + isBooleanAge + ", dummyValue=" + dummyValue
				+ ", propertyName=" + propertyName + "]";
	}
 
}
