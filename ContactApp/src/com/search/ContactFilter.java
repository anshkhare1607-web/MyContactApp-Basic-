package com.search;

import java.util.*;
import com.contact.*;

//Filtering contacts 
public interface ContactFilter {
	List<Contact> apply(List<Contact> contacts);

}
