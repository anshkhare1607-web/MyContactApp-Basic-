package com.authentication;
import java.util.*;
import com.userregistration.*;

//handling the login method from the main function
public class LoginHandler {
	public static Optional<User> handleLogin(Scanner sc, List<User> userList) {
		System.out.println("\n====LOGIN OPTIONS====");
		System.out.println("1. BasicAuth (First Name, Last Name, Password");
		System.out.println("2. OpenAuth (Email, Password");
		
		System.out.print("Enter your choice : ");
		String choice = sc.nextLine();
		Authentication authMethod;
		
		if(choice.equals("1")) {
			authMethod = new BasicAuth();
		}
		else if(choice.equals("2")) {
			authMethod = new OAuth();
		}
		else {
			System.out.println("Invalid choice");
			return Optional.empty();
		}
		Optional<User> LoggedUser = authMethod.authenticate(sc,userList); //calling authenticate function 
		if(LoggedUser.isPresent()) {
			System.out.println("Login Successfully");
			LoggedUser.get().showUserDetails();
		}
		else {
			System.out.println("Login Failed, Invalid Credentials");
		}
		return LoggedUser;
	}

}
