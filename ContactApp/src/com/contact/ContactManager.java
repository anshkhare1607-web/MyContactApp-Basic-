package com.contact;

import com.userregistration.User;
import java.util.Optional;
import java.util.Scanner;

public class ContactManager {
    public static void createContact(Scanner sc, User loggedInUser) {
        System.out.println("\n=== CREATE CONTACT ===");
        System.out.println("1. Person");
        System.out.println("2. Organization");
        System.out.print("Select contact type: ");
        String typeChoice = sc.nextLine();

        Contact newContact = null;

        if (typeChoice.equals("1")) {
            System.out.print("Enter First Name: ");
            String fName = sc.nextLine();
            System.out.print("Enter Last Name: ");
            String lName = sc.nextLine();
            newContact = new PersonContact(fName, lName);
        } else if (typeChoice.equals("2")) {
            System.out.print("Enter Organization Name: ");
            String orgName = sc.nextLine();
            System.out.print("Enter Website: ");
            String website = sc.nextLine();
            newContact = new OrganizationContact(orgName, website);
        } else {
            System.out.println("Invalid choice.");
            return;
        }

        System.out.print("Add a phone number? (y/n): ");
        while (sc.nextLine().equalsIgnoreCase("y")) {
            System.out.print("Enter Number: ");
            String num = sc.nextLine();
            System.out.print("Enter Type (Home/Work): ");
            String type = sc.nextLine();
            newContact.addMobileNumber(new MobileNumber(num, type));
            System.out.print("Add another phone number? (y/n): ");
        }

        System.out.print("Add an email? (y/n): ");
        while (sc.nextLine().equalsIgnoreCase("y")) {
            System.out.print("Enter Email Address: ");
            String email = sc.nextLine();
            System.out.print("Enter Type (Personal/Work): ");
            String type = sc.nextLine();
            newContact.addEmail(new Email(email, type));
            System.out.print("Add another email? (y/n): ");
        }

        loggedInUser.getContacts().add(newContact);
        System.out.println("\nContact added successfully!");
    }

    public static void viewContactsList(User loggedInUser) {
        System.out.println("\n=== YOUR CONTACTS LIST ===");
        if (loggedInUser.getContacts().isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }
        for (int i = 0; i < loggedInUser.getContacts().size(); i++) {
            Contact c = loggedInUser.getContacts().get(i);
            if (c instanceof PersonContact) {
                System.out.printf("%d. [Person] %s %s%n", i + 1, ((PersonContact) c).getFirstName(), ((PersonContact) c).getLastName());
            } else if (c instanceof OrganizationContact) {
                System.out.printf("%d. [Organization] %s%n", i + 1, ((OrganizationContact) c).getOrgName());
            }
        }
    }

    public static void viewContactDetails(Scanner sc, User loggedInUser) {
        viewContactsList(loggedInUser);
        if (loggedInUser.getContacts().isEmpty()) return;

        System.out.print("\nEnter contact number to view full details: ");
        try {
            int index = Integer.parseInt(sc.nextLine()) - 1;
            Optional<Contact> selectedContact = getContactByIndex(loggedInUser, index);
            
            if (selectedContact.isPresent()) {
                System.out.println("\n--- Full Contact Details ---");
                selectedContact.get().displayContact();
                System.out.println("----------------------------");
            } else {
                System.out.println("Invalid contact number.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }

    private static Optional<Contact> getContactByIndex(User user, int index) {
        if (index >= 0 && index < user.getContacts().size()) {
            return Optional.of(user.getContacts().get(index));
        }
        return Optional.empty();
    }
}