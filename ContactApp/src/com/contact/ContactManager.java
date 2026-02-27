package com.contact;

import com.userregistration.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


//Class for managing contact (personal or organizational)
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
				c.displayContact();
			} else if (c instanceof OrganizationContact) {
				System.out.printf("%d. [Organization] %s%n", i + 1, ((OrganizationContact) c).getOrgName(), ((OrganizationContact) c).getWebsite());
				c.displayContact();
			}
		}
	}

	//displaying the contact details
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

	//using index for editing
	private static Optional<Contact> getContactByIndex(User user, int index) {
		if (index >= 0 && index < user.getContacts().size()) {
			return Optional.of(user.getContacts().get(index));
		}
		return Optional.empty();
	}

	public static void editContact(Scanner sc, User loggedInUser) {
		System.out.println("\n=== EDIT CONTACT ===");
		viewContactsList(loggedInUser); 
		if (loggedInUser.getContacts().isEmpty()) return;

		System.out.print("\nEnter the number of the contact to edit: ");
		try {
			int index = Integer.parseInt(sc.nextLine()) - 1;
			if (index < 0 || index >= loggedInUser.getContacts().size()) {
				System.out.println("Invalid contact number.");
				return;
			}

			Contact originalContact = loggedInUser.getContacts().get(index);
			Contact modifiedCopy = null;

			// 1. Create a defensive deep copy using the copy constructor
			if (originalContact instanceof PersonContact) {
				modifiedCopy = new PersonContact((PersonContact) originalContact);
			} else if (originalContact instanceof OrganizationContact) {
				modifiedCopy = new OrganizationContact((OrganizationContact) originalContact);
			}

			// 2. Perform modifications on the copy with validation
			if (modifiedCopy instanceof PersonContact) {
				PersonContact pc = (PersonContact) modifiedCopy;
				System.out.print("Enter new First Name (Leave blank to keep '" + pc.getFirstName() + "'): ");
				String fName = sc.nextLine();
				if (!fName.isEmpty()) pc.setFirstName(fName); //  validation

				System.out.print("Enter new Last Name (Leave blank to keep '" + pc.getLastName() + "'): ");
				String lName = sc.nextLine();
				if (!lName.isEmpty()) pc.setLastName(lName); //  validation
			} else if (modifiedCopy instanceof OrganizationContact) {
				OrganizationContact oc = (OrganizationContact) modifiedCopy;
				System.out.print("Enter new Organization Name (Leave blank to keep '" + oc.getOrgName() + "'): ");
				String orgName = sc.nextLine();
				if (!orgName.isEmpty()) oc.setOrgName(orgName); // validation

				System.out.print("Enter new Website (Leave blank to keep '" + oc.getWebsite() + "'): ");
				String website = sc.nextLine();
				if (!website.isEmpty()) oc.setWebsite(website);
			}

			// 3. State change is committed ONLY if all validations passed
			loggedInUser.getContacts().set(index, modifiedCopy);
			System.out.println("Contact updated successfully!"); 

		} catch (NumberFormatException e) {
			System.out.println("Invalid input. Please enter a valid number.");
		} catch (IllegalArgumentException e) {
			// Rejects everything if validation fails on the copy
			System.out.println("Validation Error: " + e.getMessage());
			System.out.println("Edit aborted. Original contact remains unchanged");
		}
	}

	public static void deleteContact(Scanner sc, User loggedInUser) {
		System.out.println("\n=== DELETE CONTACT ===");
		viewContactsList(loggedInUser); 

		if (loggedInUser.getContacts().isEmpty()) return;

		System.out.print("\nEnter the number of the contact to delete: ");
		try {
			int index = Integer.parseInt(sc.nextLine()) - 1;

			if (index < 0 || index >= loggedInUser.getContacts().size()) {
				System.out.println("Invalid contact number.");
				return;
			}

			// Exception Handling: Catching valid index but just to be safe
			Contact contactToDelete = loggedInUser.getContacts().get(index);

			// Confirmation Dialog before state change
			System.out.print("Are you SURE you want to delete this contact?(y/n): ");
			String confirmation = sc.nextLine();

			if (confirmation.equalsIgnoreCase("y")) {
				// Lifecycle Management: HARD DELETE (Object reference is removed from the collection)
				loggedInUser.getContacts().remove(index);



				System.out.println("Contact deleted successfully.");
			} else {
				System.out.println("Deletion aborted. Contact is safe.");
			}

		} catch (NumberFormatException e) {
			System.out.println("Invalid input. Please enter a valid numerical ID.");
		} catch (Exception e) {
			System.out.println("An unexpected error occurred during deletion: " + e.getMessage());
		}
	}

	public static void bulkOperations(Scanner sc, User loggedInUser) {
		System.out.println("\n=== BULK OPERATIONS ===");
		viewContactsList(loggedInUser);
		if (loggedInUser.getContacts().isEmpty()) return;

		System.out.println("\n1. Bulk Delete");
		System.out.println("2. Bulk Tag");
		System.out.print("Select operation: ");
		String opChoice = sc.nextLine();

		if (!opChoice.equals("1") && !opChoice.equals("2")) {
			System.out.println("Invalid choice.");
			return;
		}

		System.out.print("Enter contact numbers separated by commas (e.g., 1, 3, 5): ");
		String input = sc.nextLine();
		String[] parts = input.split(",");

		List<Contact> selectedContacts = new ArrayList<>();

		for (String part : parts) {
			try {
				int index = Integer.parseInt(part.trim()) - 1;
				if (index >= 0 && index < loggedInUser.getContacts().size()) {
					Contact c = loggedInUser.getContacts().get(index);
					if (!selectedContacts.contains(c)) {
						selectedContacts.add(c);
					}
				} else {
					System.out.println("Warning: ID " + (index + 1) + " is out of bounds. Skipping.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Warning: '" + part.trim() + "' is not a valid number. Skipping.");
			}
		}

		if (selectedContacts.isEmpty()) {
			System.out.println("No valid contacts selected.");
			return;
		}

		if (opChoice.equals("1")) {
			System.out.print("Are you SURE you want to delete " + selectedContacts.size() + " contacts? (y/n): ");
			if (sc.nextLine().equalsIgnoreCase("y")) {
				loggedInUser.getContacts().removeAll(selectedContacts); // Hard bulk delete
				System.out.println("Bulk delete successful.");
			} else {
				System.out.println("Deletion aborted.");
			}
		} else if (opChoice.equals("2")) {
			System.out.print("Enter tag to apply to selected contacts (e.g., Work, Friend): ");
			String tag = sc.nextLine();
			if (tag != null && !tag.trim().isEmpty()) {
				for (Contact c : selectedContacts) {
					c.addTags(tag);
				}
				System.out.println("Tag applied successfully to " + selectedContacts.size() + " contacts.");
			} else {
				System.out.println("Invalid tag. Aborted.");
			}
		}
	}
}