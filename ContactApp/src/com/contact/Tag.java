package com.contact;
import java.util.Objects;

public class Tag {
	//FOR managing tags for contacts
	private String name;
	public Tag(String name) {
		if(name==null || name.isEmpty()) {
			throw new IllegalArgumentException("Tag cannot be empty");
		}
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	
	//Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		Tag tag = (Tag)o;
		return name.equalsIgnoreCase(tag.name);
	}
	
	//Override
	public int hashCode() {
		return Objects.hash(name.toLowerCase());
	}
	
	//Override
	public String toString() {
		return name;
	}
	
	
	

}
