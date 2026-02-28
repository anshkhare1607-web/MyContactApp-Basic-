package com.contact;

import java.time.LocalDateTime;
import java.util.*;

//Class for storing UUID, creation time of any contact, list of mobile numbers and emails
public abstract class Contact {

	private UUID id;
	private LocalDateTime createdAt;
	private List<MobileNumber> mobileNumbers;
	private List<Email> emails;
	private List<String> tags; //for storing tags
	private int interactionCount;
	
	public Contact() {
		this.id = UUID.randomUUID(); //generating a random UUID
		this.createdAt = LocalDateTime.now(); //Time of creation of contact
		this.mobileNumbers = new ArrayList<>(); //list for storing multiple mobile numbers
		this.emails = new ArrayList<>(); //list for storing emails
		this.tags = new ArrayList<>(); //initialize
		this.interactionCount = 0; //storing interaction count for filtering
		
	}
	

	//deep copy 
	protected Contact(Contact contact) {
		this.id = contact.id;
		this.createdAt = contact.createdAt;
		
		//copy constructor for lists
		this.mobileNumbers = new ArrayList<>();
		for(MobileNumber m : contact.mobileNumbers) {
			this.mobileNumbers.add(new MobileNumber(m));
		}
		this.emails = new ArrayList<>();
		for(Email e : contact.emails) {
			this.emails.add(new Email(e));
		}
		this.tags = new ArrayList<>(this.tags);
		this.interactionCount = contact.interactionCount;
	}
	
	public UUID getID() {
		return id;
	}
	public LocalDateTime getCreatedTime() {
		return createdAt; 
	} 
	public void addMobileNumber(MobileNumber mobile) {
		this.mobileNumbers.add(mobile);
	}
	public void addEmail(Email email) {
		this.emails.add(email);
	}
	public void addTags(String tag) {
		if(tag!=null && !tag.isEmpty()) {
			this.tags.add(tag);
		}
	}
	
	public int getInteractionCount() {
		return interactionCount;
	}

	public void incrementInteraction() {
		this.interactionCount++;
	}

	
	//Returns Defensive shallow copy of the list to protect internal state
	public List<Email> getEmails(){
		return new ArrayList<>(emails);
	}
	
	//Returns Defensive shallow copy of the list to protect internal state
	public List<MobileNumber> getMobileNumbers(){
		return new ArrayList<>(mobileNumbers);
	}
	
	public List<String> getTags(){
		return new ArrayList<>(tags);
	}
	public abstract void displayContact();
	
	
}
