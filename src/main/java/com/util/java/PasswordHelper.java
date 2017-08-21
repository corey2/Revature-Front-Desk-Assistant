package com.util.java;

import java.util.UUID;
import org.mindrot.jbcrypt.BCrypt;

public class PasswordHelper {
	public static String generatepw() {
		String uuid = UUID.randomUUID().toString();
		String longPassword = uuid.replace("-", "");
		String password = longPassword.substring(0, 8);
		return password;
	}
	
	public static String hashpw(String password) {
		String hashword = BCrypt.hashpw(password, BCrypt.gensalt());
		return hashword;
	}
	
	public static boolean checkpw(String password, String hashword) {
		try { 
			return BCrypt.checkpw(password, hashword);
		} catch (Exception e) {
			//System.out.println("Invalid salt version exception caught. The password either doesn't exist in the database, or isn't hashed.");
			return false;
		}
	}
		
}
