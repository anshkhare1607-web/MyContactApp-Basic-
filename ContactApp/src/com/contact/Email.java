package com.contact;
import com.userregistration.*;

//Storing email address and the type of email (Work/Personal)
public class Email {
	
	private String address;
	private String type;
	
	public Email(String address,String type) {
		setAddress(address);
		setType(type);
	}

	//copy constructor for deep copy
	public Email(Email email) {
		this.address = email.address;
		this.type = email.type; 
	}
	public String toString() {
		return type+": "+address;
	}
	public String getAddress() {
		return address;
	}

	//setter with validation
	public void setAddress(String address) {
		if(!EmailValidator.isValidEmail(address)) {
			throw new IllegalArgumentException("Wrong email format");
		}
		this.address = address;
	}

	public String getType() {
		return type;
	}

	//setter with validation
	public void setType(String type) {
		if(type.isEmpty() || type == null) {
			throw new IllegalArgumentException("Type can't be empty");
		}
		this.type = type;
	}
}
