package com.util.java;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Dao.java.LoginDAO;
import com.pojos.java.LoginPOJO;

public class TestDatabaseConnection {

	public static void main(String[] args) throws SQLException {
		LoginDAO dao = new LoginDAO();
		LoginPOJO user = new LoginPOJO();
    	user.setUsername("cshapiro");
    	dao.completeUserInfo(user);
		
		/*
		Connection connection = Util.getConnection();
		Statement statement = connection.createStatement();
		String selectSql = "SELECT * FROM Login";
		ResultSet resultSet = statement.executeQuery(selectSql);
		System.out.println("SQL Server Test");
		while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
        }
        */
	}

}
