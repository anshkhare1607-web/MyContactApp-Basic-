package com.contact;
import java.util.Scanner;
import com.userregistration.*;

//Managing class for contacts.
//Taking scanner and User object as an input and asking user for type of contact and their details.
public class ContactManager {
	public static void createContact(Scanner sc,User loggedUser) {
		System.out.println("\n====Create Contact====");
		System.out.println("1. Person");
		System.out.println("2. Organization");
		
		System.out.print("Select contact type: ");
		String choice = sc.nextLine();
		
		Contact newContact = null;
		if(choice.equals("1")) {
			System.out.print("Enter the first name : ");
			String fname = sc.nextLine();
			System.out.print("Enter the last name : ");
			String lname = sc.nextLine();
			
			newContact=new PersonContact(fname,lname); //Storing information in PersonContact class
		}
		else if(choice.equals("2")){
			System.out.print("Enter the Organization name : ");
			String orgName = sc.nextLine();
			System.out.print("Enter the website : ");
			String website = sc.nextLine();
			
			
			newContact = new OrganizationContact(orgName,website); //Storing information in Organization class
		}
		else {
			System.out.println("Invalid Choice");
		}
		System.out.println("Add a mobile number? (y/n): "); //Because user can enter more than one mobile number and password
		String ch = sc.nextLine();
		while(ch.equals("y")) {
			System.out.print("Enter the mobile number : ");
			String num = sc.nextLine();
			System.out.print("Enter type (Home/Work): ");
			String type = sc.nextLine();
			newContact.addMobileNumber(new MobileNumber(num,type));
			System.out.print("Want to add another number: ");
			ch = sc.nextLine();
		}
		
		System.out.println("Add an email? (y/n): ");
		String ch1 = sc.nextLine();
		while(ch1.equals("y")) {
			System.out.print("Enter the email : ");
			String email = sc.nextLine();
			System.out.print("Enter type (Personal/Work): ");
			String type = sc.nextLine();
			newContact.addEmail(new Email(email,type));
			System.out.print("Want to add another email: ");
			ch1 = sc.nextLine();
		}
		
		loggedUser.getContacts().add(newContact); //Adding loggedUser object to the List
		System.out.println("Contact Added Successfully");
	}
	
	//Displaying the contacts
	public static void viewContacts(User loggedUser) {
		System.out.println("\n====Your Contacts====");
		if(loggedUser.getContacts().isEmpty()) {
			System.out.println("No Contacts found");
			return;
		}
		for(Contact c: loggedUser.getContacts()) {
			c.displayContact();
			System.out.println("---------------");
		}
		
	}
}
