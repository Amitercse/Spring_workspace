package com.amit.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="user_data")
public class User {

	@Id
	@Column(name="user_name")
	@NotNull(message = "User name should not be empty")
	@NotBlank(message = "User name should not be empty")
	@Size(min=2, max=20, message = "User name should have length between 2 to 20")
	private String userName;
	
	@NotNull(message = "Name should not be empty")
	@NotBlank(message = "Name should not be empty")
	@Size(min=2, max=20, message = "Name should have length between 2 to 20")
	private String name;
	
	@NotNull(message = "Password should not be empty")
	@NotBlank(message = "Password should not be empty")
	private String password;
	
	@NotNull(message = "Email should not be empty")
	@NotBlank(message = "Email should not be empty")
	@Size(min=2, max=30, message = "Email should have length between 2 to 30")
	@Email(message = "{user.email.format}")
	private String email;
	
	@Column(name="date_of_birth")
	private Date dateOfBirth;
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
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", name=" + name + ", password=" + password + ", email=" + email
				+ ", dateOfBirth=" + dateOfBirth + "]";
	}

}
