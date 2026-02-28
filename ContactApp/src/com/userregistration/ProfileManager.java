package com.userregistration;

import com.contact.ContactManager;
import com.search.*;
import java.util.Scanner;
import java.util.HashMap;
//class for managing logged in profiles
public class ProfileManager {
    public static void manageProfile(Scanner sc, User loggedInUser,HashMap<String,String> credentials) {
        boolean managing = true;
        while (managing) {
        	//Options for users
            System.out.println("\n=== PROFILE MANAGEMENT ===");
            System.out.println("1. Update First Name");
            System.out.println("2. Update Last Name");
            System.out.println("3. Update Mobile Number");
            System.out.println("4. Update Email");
            System.out.println("5. Change Password");
            System.out.println("6. View Current Profile");
            System.out.println("7. Add New Contact");
            System.out.println("8. View Contacts List");
            System.out.println("9. View Specific Contact Details");
            System.out.println("10. Edit Contact");
            System.out.println("11. Delete Contact");
            System.out.println("12. Bulk Operations");
            System.out.println("13. Search Contacts");
            System.out.println("14. Logout");
            System.out.print("Enter your choice: ");
            
            String choice = sc.nextLine();
            
            switch (choice) {
                case "1": //First Name update
                    System.out.print("Enter new First Name: ");
                    String newFirstName = sc.nextLine();
                    if (!newFirstName.trim().isEmpty()) {
                        loggedInUser.getProfile().setFirstName(newFirstName);
                        System.out.println("First Name updated successfully.");
                        loggedInUser.showUserDetails();
                    } else {
                        System.out.println("Invalid input.");
                    }
                    break;
                case "2": //LastName update
                    System.out.print("Enter new Last Name: ");
                    String newLastName = sc.nextLine();
                    if (!newLastName.trim().isEmpty()) {
                        loggedInUser.getProfile().setLastName(newLastName);
                        System.out.println("Last Name updated successfully.");
                        loggedInUser.showUserDetails();
                    } else {
                        System.out.println("Invalid input.");
                    }
                    break;
                case "3": //mobile update
                    System.out.print("Enter new Mobile Number: ");
                    String newMobile = sc.nextLine();
                    if (!newMobile.trim().isEmpty()) {
                        loggedInUser.getProfile().setMobileNum(newMobile);
                        System.out.println("Mobile Number updated successfully.");
                        loggedInUser.showUserDetails();
                    } else {
                        System.out.println("Invalid input.");
                    }
                    break;
                case "4": // email update
                    System.out.print("Enter new Email: ");
                    String newEmail = sc.nextLine();
                    if (EmailValidator.isValidEmail(newEmail)) {
                        loggedInUser.setEmail(newEmail);
                        System.out.println("Email updated successfully.");
                        loggedInUser.showUserDetails();
                    } else {
                        System.out.println("Invalid Email Format.");
                    }
                    break;
                case "5": //password update
                    System.out.print("Enter new Password: ");
                    String newPassword = sc.nextLine();
                    if (!newPassword.trim().isEmpty()) {
                        String newHash = PasswordValidator.hashPassword(newPassword);
                        loggedInUser.setPasswordHash(newHash);
                        System.out.println("Password updated successfully.");
                        credentials.put(loggedInUser.getEmail(), newHash);
                        loggedInUser.showUserDetails();
                    } else {
                        System.out.println("Invalid input.");
                    }
                    break;
                case "6": //display user details
                    loggedInUser.showUserDetails();
                    break;
                case "7": //creating contact
                    ContactManager.createContact(sc, loggedInUser);
                    break;
                case "8": //displaying contact list
                    ContactManager.viewContactsList(loggedInUser);
                    break;
                case "9": //specific contact details
                    ContactManager.viewContactDetails(sc, loggedInUser);
                    break;
                case "10": //editign contact
                	ContactManager.editContact(sc, loggedInUser);
                	break;
                case "11": //deleting contact
                	ContactManager.deleteContact(sc, loggedInUser);
                	break;
                case "12": //bulk operation(delete and adding tags)
                	ContactManager.bulkOperations(sc, loggedInUser);
                	break;
                case "13": //searching contact
                	SearchManager.performSearch(sc, loggedInUser);
                	break;
                case "14": //logout
                    System.out.println("Logging out");
                    managing = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}