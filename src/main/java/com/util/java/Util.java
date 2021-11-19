package com.util.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class Util {
	private static Connection connection = null;

	
	//Do I need to add this to the run configuration for Tomcat 9?: Djava.library.path="C:\Program Files\Java\jre1.8.0_251\bin"
	
	//To get the windows authentication to work (represented by integratedSecurity=true), you need to move a file called 
	//mssql-jdbc_auth-9.4.0.x64.dll, which can be found in SQL Server JDBC Driver zip folder available here: 
	//(https://docs.microsoft.com/en-us/sql/connect/jdbc/download-microsoft-jdbc-driver-for-sql-server)
	//to the bin folder in the jdk folder in the folder where you have Java installed.
	public static Connection getConnection() {
		if (connection != null)
			return connection;
		else {
			try {
				//System.out.println("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				//System.out.println(Class.forName(driver));
				//System.out.println("????????????????????");
				//System.out.println(Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")); 
				//System.out.println("????????????????????");
				//String url = "jdbc:sqlserver://localhost;database=RFDA;integratedSecurity=true";  
				//connection = DriverManager.getConnection(url); 
				
				SQLServerDataSource sqlDs = new SQLServerDataSource();
				sqlDs.setIntegratedSecurity(true);
				sqlDs.setServerName("localhost");
				sqlDs.setDatabaseName("RFDA");
				connection = sqlDs.getConnection();
	
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
			return connection;
		}
	}
}