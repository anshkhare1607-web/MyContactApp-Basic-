package com.search;
import com.contact.*;
import java.util.*;

//using mobile number
public class MobileSearch implements ContactSearch{
	
	//Override
	public List<Contact> search(List<Contact> contacts, String query){
		List<Contact> results = new ArrayList<>(); //for storing search results
		for( Contact c : contacts) {
			for(MobileNumber m : c.getMobileNumbers()) { //traversing all the mobile number in a contact 
				if(m.toString().contains(query)) {
					results.add(c);
					break;
				}
			}
		}
		return results;
	}
}

