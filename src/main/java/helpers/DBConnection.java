package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/FarmRentSystemDB";
	private static final String USER = "saidi";
	private static final String PASSWORD = "blender1";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

	}
}