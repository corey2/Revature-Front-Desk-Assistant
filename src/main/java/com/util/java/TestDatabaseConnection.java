package com.util.java;

import java.sql.Connection;

public class TestDatabaseConnection {

	public static void main(String[] args) {
		Connection connection = Util.getConnection();
	}

}
