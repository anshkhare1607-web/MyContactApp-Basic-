package com.contact;


//Storing mobile number and the type (Home/Work)
public class MobileNumber {
	private String number;
	private String type;
	
	public MobileNumber(String number,String type) {
		setNumber(number);
		setType(type);
	}
	
	//copy constructor for deep copy
	public MobileNumber(MobileNumber mobileNumber) {
		this.number = mobileNumber.number;
		this.type = mobileNumber.type;
	}
	
	public String toString() {
		return type+": "+number;
	}

	public String getNumber() {
		return number;
	}
	
	//setter with validation
	public void setNumber(String number) {
		if(number == null || number.isEmpty()){
			throw new IllegalArgumentException("Number can't be empty");
		}
		this.number = number;
	}

	
	public String getType() {
	
		return type;
	}
	
	//setter with validation
	public void setType(String type) {
		if(number == null || number.isEmpty()){
			throw new IllegalArgumentException("Type can't be empty");
		}
		this.type = type;
	}

}
 