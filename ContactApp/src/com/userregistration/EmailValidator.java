package com.userregistration;

import java.util.regex.Pattern;
public class EmailValidator {
	private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@(.+)$";
	
	public static boolean isValidEmail(String email) {
		if(email == null) {
			return false;
		}
		return Pattern.compile(EMAIL_PATTERN).matcher(email).matches();
	}
}
