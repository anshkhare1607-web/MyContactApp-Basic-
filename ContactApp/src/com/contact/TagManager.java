package com.contact;

import com.userregistration.User;
import java.util.Scanner;

//for creating deletiing and viewing tags
public class TagManager {
	public static void manageTags(Scanner sc, User loggedInUser) {
		boolean managing = true;
		while (managing) {
			System.out.println("\n=== MANAGE TAGS ===");
			System.out.println("1. View Available Tags");
			System.out.println("2. Create New Tag");
			System.out.println("3. Delete Tag");
			System.out.println("4. Back to Main Menu");
			System.out.print("Enter your choice: ");

			String choice = sc.nextLine();

			switch (choice) {
			case "1":
				System.out.println("\n--- Your Tags ---");
				if (loggedInUser.getAvailableTags().isEmpty()) {
					System.out.println("No tags created yet.");
				} else {
					for (Tag t : loggedInUser.getAvailableTags()) {
						System.out.println("- " + t.getName());
					}
				}
				break;
			case "2":
				System.out.print("Enter new tag name: ");
				String newTagName = sc.nextLine();
				if(newTagName.trim().isEmpty()) {
					newTagName = sc.nextLine();
				}
				try {
					Tag newTag = new Tag(newTagName);
					if (loggedInUser.getAvailableTags().add(newTag)) {
						System.out.println("Tag '" + newTag.getName() + "' created successfully.");
					} else {
						System.out.println("Tag already exists.");
					}
				
				} catch (IllegalArgumentException e) {
					System.out.println("Invalid tag name.");
				}
				break;
			case "3":
				System.out.print("Enter tag name to delete: ");
				String tagToDelete = sc.nextLine();
				try {
					Tag targetTag = new Tag(tagToDelete);
					if (loggedInUser.getAvailableTags().remove(targetTag)) {
						System.out.println("Tag deleted from your available tags list.");
					} else {
						System.out.println("Tag not found.");
					}
				} catch (IllegalArgumentException e) {
					System.out.println("Invalid tag name.");
				}
				break;
			case "4":
				managing = false;
				break;
			default:
				System.out.println("Invalid choice.");
			}
		}
	}
}
