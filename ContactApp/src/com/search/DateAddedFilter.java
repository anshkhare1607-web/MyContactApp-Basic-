package com.search;
import com.contact.*;
import java.util.*;

//Filtering contacts using date added

public class DateAddedFilter implements ContactFilter{
	
	//Override
	public List<Contact> apply(List<Contact> contacts){
		List<Contact> sortedList = new ArrayList<>(contacts);
		Collections.sort(sortedList, new Comparator<Contact>() {
			
			public int compare(Contact c1, Contact c2) {
				//Sort by newest first
				return c2.getCreatedTime().compareTo(c1.getCreatedTime());
			}
		});
		return sortedList; 
	}

}
