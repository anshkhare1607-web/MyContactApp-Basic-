package com.userregistration;

import java.util.*;

import com.contact.ContactManager;

//For updating the user details
public class ProfileManager {
	public static void manageProfile(Scanner sc, User LoggedUser,HashMap<String,String> credentials) {
		boolean manage = true; //For continous access to the dashboard
		while(manage) {
			System.out.println("\n=====User DashBoard=====");
			System.out.println("1. Update Email");
			System.out.println("2. Update First Name");
			System.out.println("3. Update Last Name");
			System.out.println("4. Update Mobile Number");
			System.out.println("5. Update Password");
			System.out.println("6. View Profile");
			System.out.println("7. Add new Contact");
			System.out.println("8. View Contacts");
			System.out.println("9. Logout");

			
			System.out.print("Enter your Choice : ");
			String choice = sc.nextLine();
			
			switch(choice) {
			case "1":
				System.out.print("Enter the new email : ");
				String newEmail = sc.nextLine();
				if(EmailValidator.isValidEmail(newEmail)) {
					LoggedUser.setEmail(newEmail);
					System.out.println("Email updated");
					LoggedUser.showUserDetails();
				}
				else {
					System.out.println("Invalid email format");
				}
				break;
			case "2":
				System.out.print("Enter the new first name : ");
				String newFirstName = sc.nextLine();
				if(!newFirstName.isEmpty()) {
					LoggedUser.getProfile().setFirstName(newFirstName);
					System.out.println("Fisrt name updated");
					LoggedUser.showUserDetails();
				}
				else {
					System.out.println("Invalid input");
				}
				break;
				
			case "3":
				System.out.print("Enter the new last name : ");
				String newLastName = sc.nextLine();
				if(!newLastName.isEmpty()) {
					LoggedUser.getProfile().setLastName(newLastName);
					System.out.println("Last Name updated");
					LoggedUser.showUserDetails();
				}
				else {
					System.out.println("Invalid input");
				}
				break;
			case "4":
				System.out.print("Enter the new mobile number : ");
				String newMobileNum = sc.nextLine();
				if(!newMobileNum.isEmpty()) {
					LoggedUser.getProfile().setMobileNum(newMobileNum);
					System.out.println("Mobile number updated");
					LoggedUser.showUserDetails();
				}
				else {
					System.out.println("Invalid input");
				}
				break;
			case "5":
				System.out.print("Enter the new password: ");
				String newPassword = sc.nextLine();
				if(!newPassword.isEmpty()) {
					String newpasswordhash = PasswordValidator.hashPassword(newPassword); //creating new hash
					LoggedUser.setPasswordHash(newpasswordhash);
					System.out.println("Password updated");
					LoggedUser.showUserDetails();
					credentials.put(LoggedUser.getEmail(),newpasswordhash);
				}
				else {
					System.out.println("Invalid input");
				}
				break;
			case "6":
				LoggedUser.showUserDetails();
				break;
			case "7":
				ContactManager.createContact(sc, LoggedUser); //creating contacts
				break;
			case "8":
				ContactManager.viewContacts(LoggedUser); //displaying contacts
				break;
				
			case "9":
				System.out.println("Logging out");
				manage = false;
				break;
			default : 
				System.out.println("Invalid choice");
			}
			
		}
	}

}
