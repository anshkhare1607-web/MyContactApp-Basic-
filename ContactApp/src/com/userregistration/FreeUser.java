package com.userregistration;

//Class for free user type account
public class FreeUser extends User {
	public FreeUser(String email,String passwordHash,UserProfile profile) {
		super(email,passwordHash,profile); //Calling the User class (Parent)
	}
	
	//Override
	public void showUserDetails() {
		System.out.println("Welcome "+getProfile().getFirstName());
		System.out.println("Email "+getEmail());
		System.out.println("Mobile No. "+getProfile().getMobileNum());
		System.out.println("Free Tier Account ");
		System.out.println("==========================\n");
	}
}
