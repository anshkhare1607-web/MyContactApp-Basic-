package com.userregistration;

import java.security.MessageDigest;

//using messagedigest for creating hash of the password for authentication
public class PasswordValidator {
	public static String hashPassword(String password) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256"); //Using SHA-256 algo for hashing
			byte[] hash = digest.digest(password.getBytes("UTF-8")); //Storing hash in an array 
			StringBuilder hexString = new StringBuilder(); 
			for (byte b : hash) {
				String hex = Integer.toHexString(0xff & b); //hexadecimal format
				if(hex.length()==1) {
					hexString.append('0'); //adding 0 if the hash length is 1
				}
				hexString.append(hex); //adding each byte to stringbuilder
			}
			return hexString.toString(); //returning a string of hash password
		}
		catch (Exception e) {
			throw new RuntimeException("Error Hashing");
		}
	}
}
