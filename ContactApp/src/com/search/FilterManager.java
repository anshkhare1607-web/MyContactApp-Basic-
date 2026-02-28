package com.search;

import com.contact.*;
import com.userregistration.*;
import java.util.*;

public class FilterManager {
    public static void applyFilter(Scanner sc, User loggedInUser) {
        System.out.println("\n=== FILTER CONTACTS ===");
        if (loggedInUser.getContacts().isEmpty()) {
            System.out.println("No contacts available to filter.");
            return;
        }

        System.out.println("1. By Tag");
        System.out.println("2. By Date Added (Newest First)");
        System.out.println("3. Frequently Contacted (Most to Least)");
        System.out.print("Select filter type: ");
        String choice = sc.nextLine();

        ContactFilter filter = null;

        switch (choice) {
            case "1":
                System.out.print("Enter tag to filter by: ");
                String tag = sc.nextLine();
                filter = new TagFilter(tag);
                break;
            case "2":
                filter = new DateAddedFilter();
                break;
            case "3":
                filter = new FrequentlyContacted(); 
                break;
            default:
                System.out.println("Invalid filter choice.");
                return;
        }

        List<Contact> results = filter.apply(loggedInUser.getContacts());

        System.out.println("\n--- Filter Results ---");
        if (results.isEmpty()) {
            System.out.println("No contacts matched the filter.");
        } else {
            System.out.println("Showing " + results.size() + " contact(s):");
            for (Contact c : results) {
                c.displayContact();
                if (choice.equals("3")) {
                    System.out.println("  Interactions: " + c.getInteractionCount());
                }
                System.out.println("----------------------");
            }
        }
    }
}