package com.amit.beanFactory;

public class Address {

	private String streetName;
	private String locality;
	private String cityName;
	/**
	 * @param streetName
	 * @param locality
	 * @param cityName
	 */
	public Address(String streetName, String locality, String cityName) {
		super();
		this.streetName = streetName;
		this.locality = locality;
		this.cityName = cityName;
	}
	@Override
	public String toString() {
		return "Address [streetName=" + streetName + ", locality=" + locality + ", cityName=" + cityName + "]";
	}
	
}
