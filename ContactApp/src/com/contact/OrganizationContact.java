package com.contact;


//For Storing Organizations contact details
public class OrganizationContact extends Contact{
	private String orgName; //Name of the organization
	private String website; //Website of the organization
	
	public OrganizationContact(String orgName,String website) {
		super();
		setOrgName(orgName);
		setWebsite(website);
	}
	
	//copy constructor
	public OrganizationContact(OrganizationContact contact) {
		super(contact);
		this.orgName = orgName;
		this.website = website;
	}
	
	public void setOrgName(String orgName) {
		if(orgName == null || orgName.isEmpty()) {
			throw new IllegalArgumentException("Organizaation name can't be empty");
		}
		this.orgName = orgName;
	}
	public void setWebsite(String website) {
		if(website == null || website.isEmpty()) {
			throw new IllegalArgumentException("Email can't be empty");
		}
		this.website = website;
	}
	
	
	 public String getOrgName() {
		 return orgName;
	 }
	 public String getWebsite(){
		 return website; 
	 }
	//override
	public void displayContact() {
		System.out.printf("Organization Name : %s \n Website : %s%n",orgName,website);
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
