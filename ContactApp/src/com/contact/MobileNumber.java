package com.contact;


//Storing mobile number and the type (Home/Work)
public class MobileNumber {
	private String number;
	private String type;
	
	public MobileNumber(String number,String type) {
		this.number = number;
		this.type = type;
	}
	
	public String toString() {
		return type+": "+number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
 