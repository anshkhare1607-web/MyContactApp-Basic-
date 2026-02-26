package com.authentication;
import java.util.*;


import com.userregistration.*;

//BasicAuth using firstname, lastname and password
public class BasicAuth implements Authentication{
	//override
	public Optional<User> authenticate(Scanner sc, List<User> userList){
		System.out.print("Enter first name : ");
		String firstName = sc.nextLine();
		
		System.out.print("Enter last name : ");
		String lastName = sc.nextLine();
		
		System.out.print("Enter password : ");
		String password = sc.nextLine();
		
		String hash = PasswordValidator.hashPassword(password); //creating hash of the password for authenticating
		
		for(User user : userList) {
			if(user.getProfile().getFirstName().equals(firstName) && user.getProfile().getLastName().equals(lastName) 
					&& user.getPasswordHash().equals(hash)) { //matching the values
				return Optional.of(user);
				
			}
		}
		return Optional.empty();
	}
}


