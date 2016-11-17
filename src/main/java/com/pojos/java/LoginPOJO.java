package com.pojos.java;

public class LoginPOJO {
	private String username;
	private String password;
	private int userRole;
	
	public LoginPOJO(){
		this.username = null;
		this.password = null;
		this.userRole = 0;
	}
	
	public LoginPOJO(String username, String password, int userRole){
		this.username = username;
		this.password = password;
		this.userRole = userRole;
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getUserRole() {
		return userRole;
	}

	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}
}