package com.util.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
	private static Connection connection = null;

	//Simple connect statements to connect to the database.
	//Had to hard code them because they were not getting them from the file.
	public static Connection getConnection() {
		if (connection != null)
			return connection;
		else {
			try {
                //Properties prop = new Properties();
                //InputStream inputStream = Util.class.getClassLoader().getResourceAsStream("db-config.properties");
                //prop.load(inputStream);
				String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
				String url = "jdbc:sqlserver://localhost;databasename=RFDA";
				//String user = "clshaps93";
				//String password = "coreyls93";
				//System.out.println("Here1");
				Class.forName(driver);
				//DriverManager.registerDriver (new oracle.jdbc.OracleDriver());
				//System.out.println("Here2");
				connection = DriverManager.getConnection(url);
				
				Statement statement = connection.createStatement();
				String selectSql = "SELECT * FROM Login";
				ResultSet resultSet = statement.executeQuery(selectSql);
				System.out.println("SQL Server Test");
				while (resultSet.next()) {
	                System.out.println(resultSet.getString(2) + " " + resultSet.getString(3));
	            }
			} catch (Exception e) {
				e.printStackTrace();
			}
			return connection;
		}
	}
}