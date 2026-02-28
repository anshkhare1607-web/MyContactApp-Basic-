package com.search;
import com.contact.*;
import java.util.*;

//Using tags
public class TagSearch implements ContactSearch{

	public List<Contact> search(List<Contact> contacts,String query){
		
		//Override
		List<Contact> results = new ArrayList<>();
		String lowerQuery = query.toLowerCase();
		
		for(Contact c : contacts) {
			for(String tag : c.getTags()) {
				if(tag.toLowerCase().contains(lowerQuery)) {
					results.add(c);
					
				}
			}
		}
		
		return results;
		
	}
}
