package com.userregistration;


//Class of premium user
public class PremiumUser extends User {
	
	public PremiumUser(String email,String passwordHash,UserProfile profile) {
		super(email,passwordHash,profile); //calling parent class User for storing the details.
	}
	
	//Override
	public void showUserDetails() { //function for printing the user details
		System.out.println("Welcome "+getProfile().getFirstName());
		System.out.println("Email "+getEmail());
		System.out.println("Mobile No. "+getProfile().getMobileNum());
		System.out.println("PREMIUM Tier Account.");
		System.out.println("==========================\n");
	}
}
