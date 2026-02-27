package com.userregistration;
import java.util.*;
import com.contact.Contact;

//Base class User for storing email, passwordhash and UserProfile
public abstract class User {
	private String email;
	private String passwordHash;
	private UserProfile profile;
	private List<Contact> contacts = new ArrayList<>(); //Storing contacts for each user
	
	public User(String email,String passwordHash,UserProfile profile) {
		this.email = email;
		this.passwordHash = passwordHash;
		this.profile = profile;
	}
	
	//setter and getter functions for ensuring encapsulation
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	public UserProfile getProfile() {
		return profile;
	}
	public void setProfileInfo(UserProfile profile) {
		this.profile = profile;
	}
	
	public List<Contact> getContacts(){
		return contacts;
	}
	public abstract void showUserDetails();
}
