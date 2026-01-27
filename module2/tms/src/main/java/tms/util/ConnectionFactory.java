package tms.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

			driver = properties.getProperty("jdbc.driver");
			url = properties.getProperty("jdbc.url");
			username = properties.getProperty("jdbc.username");
			password = properties.getProperty("jdbc.password");
//           System.out.println(driver);
//           System.out.println(url);
//           System.out.println(username);
//           System.out.println(password);
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
