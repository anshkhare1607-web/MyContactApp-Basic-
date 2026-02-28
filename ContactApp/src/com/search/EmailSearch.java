package com.search;
import com.contact.*;
import java.util.*;

//using emails
public class EmailSearch implements ContactSearch{

	//Override
	public List<Contact> search(List<Contact> contacts, String query){
		List<Contact> results = new ArrayList<>();
		
		String lowerQuery = query.toLowerCase();
		for(Contact c : contacts) {
			for(Email e : c.getEmails()) {
				if(e.toString().toLowerCase().contains(lowerQuery)) {
					results.add(c);
					break;
				}
			}
		}
		return results;
		
	}
}
