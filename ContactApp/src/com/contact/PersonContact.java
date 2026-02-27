package com.contact;


//FOr Storing the person's contact details (firstname, lastname)
public class PersonContact extends Contact{
	private String fname;
	private String lname;
	
	public PersonContact(String fname,String lname) {
		this.fname = fname;
		this.lname = lname;
	}
	//override
	public void displayContact() {
		System.out.println("Person: "+fname+" "+lname);
		for(MobileNumber m : getMobileNumbers()) {
			System.out.println(" "+m);
		}
		for(Email e : getEmails()) {
			System.out.println(" "+e);
		}
	}

}
