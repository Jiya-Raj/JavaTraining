package com.bookstore.util;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class ConnectionFactory {
	private static Connection connection;
	static String driver;
	static String url;
	static String username;
	static String password;

	public static Connection getConnection() {
		FileInputStream is = null;
		Properties properties = new Properties();

		try {
			is = new FileInputStream("db.properties");
			properties.load(is);

			driver = properties.getProperty(driver);
			url = properties.getProperty(url);
			username = properties.getProperty(username);
			password = properties.getProperty(password);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}
}
