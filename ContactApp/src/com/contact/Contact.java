package com.contact;

import java.time.LocalDateTime;
import java.util.*;

//Class for storing UUID, creation time of any contact, list of mobile numbers and emails
public abstract class Contact {

	private UUID id;
	private LocalDateTime createdAt;
	private List<MobileNumber> mobileNumbers;
	private List<Email> emails;
	
	public Contact() {
		this.id = UUID.randomUUID(); //generating a random UUID
		this.createdAt = LocalDateTime.now(); //Time of creation of contact
		this.mobileNumbers = new ArrayList<>(); //list for storing multiple mobile numbers
		this.emails = new ArrayList<>(); //list for storing emails
	}
	public void addMobileNumber(MobileNumber mobile) {
		this.mobileNumbers.add(mobile);
	}
	public void addEmail(Email email) {
		this.emails.add(email);
	}
	public List<MobileNumber> getMobileNumbers(){
		return mobileNumbers;
	}
	public List<Email> getEmails(){
		return emails;
	}
	
	public abstract void displayContact();
	
	
}
