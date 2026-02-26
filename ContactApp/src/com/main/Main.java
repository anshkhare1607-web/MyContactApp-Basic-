package com.main;

import com.userregistration.*;
import java.util.*;
public class Main {
	
	
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		List<User> userList = new ArrayList<>();
		HashMap<String, String> credentials = new HashMap<>();
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
				NewUser.registerUser(sc,userList,credentials);
				break;
			
			case 2:
				//loginUser(sc);
				break;
			case 3:
				System.out.println("Exiting");
				running = false;
				break;
			default:
				System.out.println("Invalid Choice");
			}
		}
		System.out.println();
		for(User us : userList) {
			us.showUserDetails();
			System.out.println();
		}
	}


	


}
