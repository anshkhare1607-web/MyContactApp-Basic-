package com.userregistration;

import com.contact.ContactManager;
import com.userregistration.*;
import java.util.Scanner;
import java.util.HashMap;

public class ProfileManager {
    public static void manageProfile(Scanner sc, User loggedInUser,HashMap<String,String> credentials) {
        boolean managing = true;
        while (managing) {
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
            System.out.println("12. Logout");
            System.out.print("Enter your choice: ");
            
            String choice = sc.nextLine();
            
            switch (choice) {
                case "1":
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
                case "2":
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
                case "3":
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
                case "4":
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
                case "5":
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
                case "6":
                    loggedInUser.showUserDetails();
                    break;
                case "7":
                    ContactManager.createContact(sc, loggedInUser);
                    break;
                case "8":
                    ContactManager.viewContactsList(loggedInUser);
                    break;
                case "9":
                    ContactManager.viewContactDetails(sc, loggedInUser);
                    break;
                case "10":
                	ContactManager.editContact(sc, loggedInUser);
                	break;
                case "11":
                	ContactManager.deleteContact(sc, loggedInUser);
                	break;
                case "12":
                    System.out.println("Logging out");
                    managing = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}