package com.eshoppingzone.profile.UserProfileService.pojo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserProfile {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int profileId;
	private String fullName;
	private String image;
	private String emailId;
	private String phoneNo;
	@Embedded
	@ElementCollection
	private List<Address> Addresses;
	private String about;
	private LocalDate dateOfBirth;
	private String gender;
	private String role;
	
	
	
	public UserProfile(int profileId, String fullName, String image, String emailId, String phoneNo,
			List<Address> addresses, String about, LocalDate dateOfBirth, String gender, String role) {
		super();
		this.profileId = profileId;
		this.fullName = fullName;
		this.image = image;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
		Addresses = addresses;
		this.about = about;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.role = role;
	}
		
	public UserProfile()
	{
		
	}
	
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public List<Address> getAddresses() {
		return Addresses;
	}
	public void setAddresses(List<Address> addresses) {
		Addresses = addresses;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
