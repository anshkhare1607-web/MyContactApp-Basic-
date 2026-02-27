package com.contact;


//FOr Storing the person's contact details (firstname, lastname)
public class PersonContact extends Contact{
	private String fname;
	private String lname;
	
	public PersonContact(String fname,String lname) {
		super();
		this.fname = fname;
		this.lname = lname;
	}
	
	public String getFirstName() {
		return fname;
	}
	public String getLastName() {
		return lname;
	}
	//override
	public void displayContact() {
		System.out.printf("Person: %s %s%n",fname,lname);
		System.out.printf("Contact ID : %s%n",getID());
		System.out.printf("Created at : %s%n",getCreatedTime()); 
		for(MobileNumber m : getMobileNumbers()) {
			System.out.println(" "+m);
		}
		for(Email e : getEmails()) {
			System.out.println(" "+e);
		}
	}

}
