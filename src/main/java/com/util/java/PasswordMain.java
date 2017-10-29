package com.util.java;

public class PasswordMain {
	public static void main(String[] args) {
		String hashword = PasswordHelper.hashpw("admin");
		System.out.println(hashword);
	}
}


