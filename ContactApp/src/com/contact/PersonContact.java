package com.contact;


//FOr Storing the person's contact details (firstname, lastname)
public class PersonContact extends Contact{
	private String fname;
	private String lname;
	
	public PersonContact(String fname,String lname) {
		super();
		setFirstName(fname);
		setLastName(lname);
	}
	
	//copy constructor
	public PersonContact(PersonContact contact) {
		super(contact); // Calls contact copy constructor for deep copy of base fields
		this.fname = contact.fname;
		this.lname = contact.lname;
	}
	
	public String getFirstName() {
		return fname;
	}
	
	public void setFirstName(String fname) {
		if(fname == null || fname.isEmpty()) {
			throw new IllegalArgumentException("First name can't be empty");
		}
		this.fname = fname;
	}
	public String getLastName() {
		return lname;
	}
	
	public void setLastName(String lname) {
		if(lname == null || lname.isEmpty()) {
			throw new IllegalArgumentException("Last name can't be empty");
		}
		this.lname = lname;
	}
	//override
	public void displayContact() {
		System.out.printf("Person: %s %s%n",fname,lname);
		System.out.printf("Tags: %s%n",getTags());
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
