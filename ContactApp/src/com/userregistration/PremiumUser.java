package com.userregistration;

public class PremiumUser extends User {
	public PremiumUser(String email,String passwordHash,UserProfile profile) {
		super(email,passwordHash,profile);
	}
	
	//Override
	public void showUserDetails() {
		System.out.println("Welcome "+getProfile().getFirstName());
		System.out.println("Email "+getEmail());
		System.out.println("Mobile No. "+getProfile().getMobileNum());
		System.out.println("PREMIUM Tier Account.");
		System.out.println("==========================\n");
	}
}
