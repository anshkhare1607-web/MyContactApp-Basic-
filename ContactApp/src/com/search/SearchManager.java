package com.search;

import com.userregistration.*;
import com.contact.*;
import java.util.*;

public class SearchManager {
	
	public static void performSearch(Scanner sc , User LoggedUser) {
		System.out.println("==== Search Contacts ====");
		if(LoggedUser.getContacts().isEmpty()) {
			System.out.println("No contacts to search");
			return;
		}
		System.out.println("1. By name");
		System.out.println("2. By Mobile");
		System.out.println("3. By Email");
		System.out.println("4. By Tag");
		System.out.print("Enter the choice : ");
		String choice = sc.nextLine();
		ContactSearch searcher = null;
		
		switch(choice) {
		
		case "1":
			searcher = new NameSearch();
			break;
		case "2":
			searcher = new MobileSearch();
			break;
		case "3":
			searcher = new EmailSearch();
			break;
		case "4":
			searcher = new TagSearch();
			break;
			
		default:
			System.out.println("Invalid choice");
			break;
		}
		
		System.out.print("Enter the search query: ");
		String query = sc.nextLine();
		
		List<Contact> results = searcher.search(LoggedUser.getContacts(),query);
		System.out.println("---Search Results---");
		if(results.isEmpty()) System.out.println("No contact found");
		else {
			System.out.println("Found "+results.size()+" Contact(s)-");
			for(Contact c : results) {
				c.displayContact();
				System.out.println("--------");
			}
		}
	}
}
