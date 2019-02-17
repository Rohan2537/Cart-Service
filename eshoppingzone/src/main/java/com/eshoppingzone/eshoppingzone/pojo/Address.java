package com.eshoppingzone.eshoppingzone.pojo;

public class Address {
	private Integer customerId;
	private String fullName;
	private String mobileNumber;
	private Integer flatNumber;
	private String city;
	private Integer pincode;
	private String state;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(Integer customerId, String fullName, String mobileNumber, Integer flatNumber, String city,
			Integer pincode, String state) {
		super();
		this.customerId = customerId;
		this.fullName = fullName;
		this.mobileNumber = mobileNumber;
		this.flatNumber = flatNumber;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
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
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Address [customerId=" + customerId + ", fullName=" + fullName + ", mobileNumber=" + mobileNumber
				+ ", flatNumber=" + flatNumber + ", city=" + city + ", pincode=" + pincode + ", state=" + state + "]";
	}

}
