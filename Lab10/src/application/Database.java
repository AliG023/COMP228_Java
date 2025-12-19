package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	
	// Database Configuration
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/lab10";
    private static final String DB_USER = Dotenv.get("DB_USER", "");
    private static final String DB_PASSWORD = Dotenv.get("DB_PASSWORD", "");

    private Database (){

    }
    
    // Establish Database Connection
	public static Connection getDBConnection() {
		Connection connection = null;

		try {
		    Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException ex) {
			System.out.println(ex.getStackTrace());
			System.out.println(ex.getMessage());
		}

		try {
			connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			return connection;
		} catch (SQLException ex) {
			System.out.println(ex.getSQLState());
			System.out.println(ex.getMessage());
		}

		return connection;
	}
}