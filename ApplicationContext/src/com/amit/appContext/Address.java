package com.amit.appContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Address {

	private int streetNo;
	private String localityName;
	private String city;
	
	public Address(@Value("123") int streetNo, @Value("Kormangala") String locality, @Value("Bangalore") String city) {
		this.streetNo= streetNo;
		this.localityName= locality;
		this.city= city;
	}
	
	/**
	 * @return the streetNo
	 */
	public int getStreetNo() {
		return streetNo;
	}
	/**
	 * @param streetNo the streetNo to set
	 */
	public void setStreetNo(int streetNo) {
		this.streetNo = streetNo;
	}
	/**
	 * @return the localityName
	 */
	public String getLocalityName() {
		return localityName;
	}
	/**
	 * @param localityName the localityName to set
	 */
	public void setLocalityName(String localityName) {
		this.localityName = localityName;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address [streetNo=" + streetNo + ", localityName=" + localityName + ", city=" + city + "]";
	}
}
