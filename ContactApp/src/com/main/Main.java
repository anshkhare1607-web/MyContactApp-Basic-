package com.main;
import com.userregistration.*;
import com.authentication.*;
import java.util.*;

//Main function
public class Main {
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		List<User> userList = new ArrayList<>(); //for storing user objects
		HashMap<String, String> credentials = new HashMap<>(); //for storing email and passwords
		boolean running = true;
		while(running) {
			System.out.println("===MENU===");
			System.out.println("1. Create User");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			System.out.print("Enter your choice : ");
			int choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				NewUser.registerUser(sc,userList,credentials); //creating new user
				break;
			case 2:
				LoginHandler.handleLogin(sc, userList); //logging in using authentication
				break;
			case 3:
				System.out.println("Exiting"); //exiting the app
				running = false;
				break;
			default:
				System.out.println("Invalid Choice");
			}
		}
		System.out.println();
		for(User us : userList) {
			us.showUserDetails(); //displaying user details
			System.out.println();
		}
	}


	


}
