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
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the userRole
	 */
	public int getUserRole() {
		return userRole;
	}
	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}
}