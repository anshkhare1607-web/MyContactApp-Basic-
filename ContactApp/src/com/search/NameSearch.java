package com.search;
import com.contact.*;
import java.util.*;

//For searching using firstname or lastname
public class NameSearch implements ContactSearch{
	
	//Override
	public List<Contact> search(List<Contact> contacts, String query){
		List<Contact> results = new ArrayList<>(); //for storing search results
		String lowerQuery = query.toLowerCase();
		
		for(Contact c:contacts) {
			if(c instanceof PersonContact) {
				PersonContact pc= (PersonContact)c;
				if(pc.getFirstName().toLowerCase().contains(lowerQuery)) {
					results.add(c);
				}
				else if(c instanceof OrganizationContact) {
					OrganizationContact oc = (OrganizationContact)c;
					if(oc.getOrgName().toLowerCase().contains(lowerQuery)) {
						results.add(c);
					}
				}
			}
		}
		return results;
		
	}

}
