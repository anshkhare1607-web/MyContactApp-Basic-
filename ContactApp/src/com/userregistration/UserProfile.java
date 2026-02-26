package com.userregistration;

//for storing user details -> firstname lastname and mobile number
public class UserProfile {
	private String firstName;
	private String lastName;
	private String mobileNum;
	
	public UserProfile(String firstName,String lastName,String mobileNum) { //assigning values
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNum = mobileNum;
	}
	
	//setter and getter functions for encapsulation
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}
}
