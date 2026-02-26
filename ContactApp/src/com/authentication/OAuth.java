package com.authentication;
import com.userregistration.*;
import java.util.*;

//OpenAuth using email and password
public class OAuth implements Authentication{
	//override
	public Optional<User> authenticate(Scanner sc,List<User> userList){ 
		System.out.print("Enter your email : ");
		String email = sc.nextLine();
		
		System.out.print("Enter password : ");
		String password = sc.nextLine();
		String hash = PasswordValidator.hashPassword(password);
		
		for(User user:userList) {
			if(user.getEmail().equals(email) && user.getPasswordHash().equals(hash)) {
				return Optional.of(user);
			}
		}
		return Optional.empty();		
	}
}
