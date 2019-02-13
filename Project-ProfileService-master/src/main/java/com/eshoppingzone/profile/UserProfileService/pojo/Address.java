package com.eshoppingzone.profile.UserProfileService.pojo;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	 private int houseNumber;
	 private String streetName;
	 private String colonyName;
	 private String city;
	 private String State;
	 private int pincode;
	public Address(int houseNumber, String streetName, String colonyName, String city, String state, int pincode) {
		super();
		this.houseNumber = houseNumber;
		this.streetName = streetName;
		this.colonyName = colonyName;
		this.city = city;
		State = state;
		this.pincode = pincode;
	}
	 
	 public Address()
	 {
		 
	 }

	public int getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getColonyName() {
		return colonyName;
	}

	public void setColonyName(String colonyName) {
		this.colonyName = colonyName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	 
}
