package com.contact;


//For Storing Organizations contact details
public class OrganizationContact extends Contact{
	private String orgName; //Name of the organization
	private String website; //Website of the organization
	
	public OrganizationContact(String orgName,String website) {
		this.orgName = orgName;
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
