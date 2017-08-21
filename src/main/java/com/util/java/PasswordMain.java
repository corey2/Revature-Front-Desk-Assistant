package com.util.java;

public class PasswordMain {
	public static void main(String[] args) {
		String hashword = PasswordHelper.hashpw("password");
		System.out.println(hashword);
	}
}
