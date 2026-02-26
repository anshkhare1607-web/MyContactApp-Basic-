package com.userregistration;
import java.util.*;

//User creation class
public class NewUser {
	
	//Scaner for taking input, Using list for storing user objects and map for storing email and password
	public static void registerUser(Scanner sc,List<User> userList,HashMap<String,String> credentials) {
		System.out.println("===HELLO NEW USER===");
		System.out.print("Enter the email : ");
		String email = sc.nextLine();
		if(!EmailValidator.isValidEmail(email)) { //validating email format before storing
			System.out.println("Invalid Email Format");
			return;
		}
		if(credentials.containsKey(email)) { //checking if the email is already exist in te database
			System.out.println("Email already exists");
			return;
		}
		System.out.print("Enter the password : ");
		String password = sc.nextLine();
		String passwordHash = PasswordValidator.hashPassword(password); // creating hash of the password
		System.out.println();
		
		System.out.println("Enter the UserProfile ->"); //taking user details
		System.out.print("Enter your first name : ");
		String firstName = sc.nextLine();
		System.out.print("Enter your last name : ");
		String lastName = sc.nextLine();
		System.out.print("Enter your mobile number : ");
		String mobileNum = sc.nextLine();
		System.out.print("Enter account type : (Free/Premium) ->");
		String type = sc.nextLine();
		UserProfile profile = new UserProfile(firstName,lastName,mobileNum); //feeding data to the UserProfle class
		User newUser;
		if(type.equalsIgnoreCase("Premium")) {
			newUser = new PremiumUser(email,passwordHash,profile); //Calling PrmiumUser class 
		}
		else {
			newUser = new FreeUser(email,passwordHash,profile); //Calling FreeUser class
		}
		userList.add(newUser); //Adding new user object to the list
		credentials.put(email,passwordHash); //adding email and hash of password to the map
		System.out.println("New User Registered Successfully");
		newUser.showUserDetails(); //printing the details of the user
	}
}
