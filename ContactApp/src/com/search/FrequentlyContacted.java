package com.search;
import com.contact.*;
import java.util.*;

//Sorting in the basis of frequently contacted contacts
public class FrequentlyContacted implements ContactFilter{
	
	//Override
	public List<Contact> apply(List<Contact> contacts){
		List<Contact> sortedList = new ArrayList<>(contacts);
		Collections.sort(sortedList, new Comparator<Contact>() { 
			
			public int compare(Contact c1, Contact c2) {
				//Sorting by highest number of interactions
				return Integer.compare(c2.getInteractionCount(), c1.getInteractionCount());
			}
			
		});
		return sortedList;
	}
}
