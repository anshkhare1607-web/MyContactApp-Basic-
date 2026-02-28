package com.search;

import com.contact.*;
import java.util.List;

//Interface for searching contact
public interface ContactSearch {
	
	List<Contact> search(List<Contact> contacts,String query); //search method for searching contacts using different queries

}
