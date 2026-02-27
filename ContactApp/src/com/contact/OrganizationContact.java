package com.contact;


//For Storing Organizations contact details
public class OrganizationContact extends Contact{
	private String orgName; //Name of the organization
	private String website; //Website of the organization
	
	public OrganizationContact(String orgName,String website) {
		this.orgName = orgName;
		this.website = website;
	}
	
	//override
	public void displayContact() {
		System.out.println("Organization: "+orgName+"\nWebsite: "+website);
		for(MobileNumber m : getMobileNumbers()) {
			System.out.println(" "+m);
		}
		for(Email e : getEmails()) {
			System.out.println(" "+e);
		}
	}

}
