package com.Dao.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pojos.java.LoginPOJO;
import com.util.java.Util;

public class LoginDAO {
	private Connection connection = null;

	public LoginDAO() {
		connection = Util.getConnection();
	}

	public void completeUserInfo(LoginPOJO user) {
		System.out.println("Starting completeUserInfo dao method. The user is "+user.getUsername());
		ResultSet rs = null;
		try {  //Gets hashed password and user role from the database using the given username.
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT Password, Userrole FROM Login WHERE Username=?");
			//System.out.println("The username for this user is "+user.getUsername());
			preparedStatement.setString(1, user.getUsername());
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				//System.out.println("The password stored in the database for this user is "+rs.getString("password"));
				user.setPassword(rs.getString("password"));
				user.setUserRole(rs.getInt("userrole")); 
			}
			//System.out.println("The password that was just put into the user POJO is "+user.getPassword());
			//System.out.println("The user role for this user is "+user.getUserRole());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void storePassword(LoginPOJO login) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO Login(Username,Password,UserRole) VALUES (?,?,?)");
			preparedStatement.setString(1, login.getUsername());
			preparedStatement.setString(2, login.getPassword());
			preparedStatement.setInt(3, login.getUserRole());
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updatePassword(LoginPOJO login) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE Login SET Password=? WHERE Username=?");
			preparedStatement.setString(1, login.getPassword());
			preparedStatement.setString(2, login.getUsername());
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteLoginRecord(LoginPOJO login) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("DELETE FROM Login WHERE Username=?");
			preparedStatement.setString(1, login.getUsername());
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
