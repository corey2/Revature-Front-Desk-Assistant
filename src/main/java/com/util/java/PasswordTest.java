package com.util.java;

import com.pojos.java.PasswordHelper;

public class PasswordTest {

	public static void main(String[] args) {
		String hw = PasswordHelper.hashpw("Coreyls93!");
		System.out.println("Hashed Password: "+hw);
		System.out.println("Password Check: "+PasswordHelper.checkpw("Coreyls93!", hw));
	}

}
