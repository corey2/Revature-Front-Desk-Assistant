package com.util.java;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

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
/*                InputStream inputStream = Util.class.getClassLoader().getResourceAsStream("db-config.properties");
                prop.load(inputStream);*/
				String driver = "oracle.jdbc.OracleDriver";
				String url = "jdbc:oracle:thin:@rdbs-sudo.cwboiusxaivt.us-east-1.rds.amazonaws.com:1521:ORCL";
				String user = "ldclauss2";
				String password = "Kirito7887";
				Class.forName(driver);
				connection = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} /*catch (IOException e) {
				e.printStackTrace();
			}*/
			return connection;
		}
	}
}