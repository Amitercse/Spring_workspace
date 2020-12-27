package com.amit.profile;

public class XmlController {

	private XmlService xmlService;
	
	private String url;
	
	private String userName;
	
	private String password;
	
	public void performOperation()
	{
		xmlService.performOperation();
	}

	/**
	 * @return the xmlService
	 */
	public XmlService getXmlService() {
		return xmlService;
	}

	/**
	 * @param xmlService the xmlService to set
	 */
	public void setXmlService(XmlService xmlService) {
		this.xmlService = xmlService;
	}
	
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
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
	 * Read data from properties file based on profile
	 */
	public void readProfileBasedProperties()
	{
		System.out.println("Reading properties from xml controller");
		System.out.println(url);
		System.out.println(userName);
		System.out.println(password);
	}
}
