package com.userregistration;

import java.util.*;

public class NewUser {
	public static void registerUser(Scanner sc,List<User> userList,HashMap<String,String> credentials) {

		System.out.println("===HELLO NEW USER===");
		System.out.print("Enter the email : ");
		String email = sc.nextLine();
		if(!EmailValidator.isValidEmail(email)) {
			System.out.println("Invalid Email Format");
			return;
		}
		if(credentials.containsKey(email)) {
			System.out.println("Email already exists");
			return;
		}
		
		System.out.print("Enter the password : ");
		String password = sc.nextLine();
		String passwordHash = PasswordValidator.hashPassword(password);
		System.out.println();
		System.out.println("Enter the UserProfile ->");
		System.out.print("Enter your first name : ");
		String firstName = sc.nextLine();
		System.out.print("Enter your last name : ");
		String lastName = sc.nextLine();
		System.out.print("Enter your mobile number : ");
		String mobileNum = sc.nextLine();
		System.out.print("Enter account type : (Free/Premium) ->");
		String type = sc.nextLine();
		
		UserProfile profile = new UserProfile(firstName,lastName,mobileNum);
		User newUser;
		if(type.equalsIgnoreCase("Premium")) {
			newUser = new PremiumUser(email,passwordHash,profile);
		}
		else {
			newUser = new FreeUser(email,passwordHash,profile);
		}
		userList.add(newUser);
		credentials.put(email,passwordHash);
		System.out.println("New User Registered Successfully");
		newUser.showUserDetails();
	}
}
