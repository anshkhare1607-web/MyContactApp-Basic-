package com.contact;


//Storing email address and the type of email (Work/Personal)
public class Email {
	
	private String address;
	private String type;
	
	public Email(String address,String type) {
		this.address = address;
		this.type = type;
	}

	public String toString() {
		return type+": "+address;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

}
