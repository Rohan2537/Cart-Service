package com.cg.order.orderservice.orders.address;

public class Address {
	private String fullName;
	private Integer mobileNumber;
	private Integer flatNumber;
	private String city;
	private Integer pincode;
	private String State;

	public Address() {
		super();

	}

	public Address(String fullName, Integer mobileNumber, Integer flatNumber, String city, Integer pincode,
			String state) {
		super();
		this.fullName = fullName;
		this.mobileNumber = mobileNumber;
		this.flatNumber = flatNumber;
		this.city = city;
		this.pincode = pincode;
		State = state;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Integer mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Integer getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(Integer flatNumber) {
		this.flatNumber = flatNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	@Override
	public String toString() {
		return "Address [fullName=" + fullName + ", mobileNumber=" + mobileNumber + ", flatNumber=" + flatNumber
				+ ", city=" + city + ", pincode=" + pincode + ", State=" + State + "]";
	}

	
}
