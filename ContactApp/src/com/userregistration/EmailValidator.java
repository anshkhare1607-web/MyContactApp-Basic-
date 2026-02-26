package com.userregistration;

import java.util.regex.Pattern;

//validating email using regex
public class EmailValidator {
	private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@(.+)$"; // format -> mail@domain.com
	public static boolean isValidEmail(String email) {
		if(email == null) {
			return false;
		}
		return Pattern.compile(EMAIL_PATTERN).matcher(email).matches(); //using pattern class for mathcing the expression with the input email
	}
}

