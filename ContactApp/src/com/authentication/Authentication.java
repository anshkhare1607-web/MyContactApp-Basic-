package com.authentication;
import java.util.*;
import com.userregistration.*;
 //interface authentication for creating other authentication functions in future
public interface Authentication {
	Optional<User> authenticate(Scanner sc,List<User> userList); //using Optional<> for handling null values
}
