package com.util.java;

import java.sql.Connection;
import java.sql.DriverManager;

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
				String driver = "oracle.jdbc.OracleDriver";
				String url = "jdbc:oracle:thin:@rfda.ct6hxvbzykg1.us-west-2.rds.amazonaws.com:1521:ORCL";
				String user = "clshaps93";
				String password = "coreyls93";
				Class.forName(driver);
				connection = DriverManager.getConnection(url, user, password);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return connection;
		}
	}
}