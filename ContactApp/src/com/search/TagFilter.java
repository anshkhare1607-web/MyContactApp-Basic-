package com.search;
import com.contact.*;
import java.util.*;

//filtering contact on the basis of tags
public class TagFilter implements ContactFilter{
	private String targetTag;
	
	public TagFilter(String targetTag) { //setter function
		this.targetTag = targetTag;
	}
	
	//Override
	public List<Contact> apply(List<Contact> contacts){
		List<Contact> filtered = new ArrayList<>();
		for(Contact c : contacts) {
			for(String tag : c.getTags()) {
				if(tag.equalsIgnoreCase(tag)) {
					filtered.add(c);
					break;
				}
			}
		}
		return filtered;
	}
}
