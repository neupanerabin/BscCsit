package mysql_Optimized;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Db_Connection {

	// connection Parameters
	final String DRIVER = "com.mysql.cj.jdbc.Driver"; // Driver link provided

	final String DBNAME = "JavaCollege"; // Database table name
	final String HOST = "localhost"; // hosting site
	final String DBUSER = "root"; // database name
	final String DBPASS = "Neupane@11"; // password
	final int PORT = 3306;
	final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DBNAME;

	Connection connect; // Connection object

	// Methods to establish a database Connection
	public Connection getConnection() {

		try {
			// Load the JDBC driver class
			Class.forName(DRIVER);

			// Establish connection to driver
			connect = DriverManager.getConnection(URL, DBUSER, DBPASS);

		} catch (Exception ex) {
			// Print an error message and the full stack trace for debugging
			System.out.printf("Error: database ", ex.getMessage());
			ex.printStackTrace(); // Print the full stack trace for debugging
			System.out.println("Error: Unable to establish a database connection");
		}

		return connect;
	}

	// Print an error message and the full stack trace for debugging
	public void CloseConnection() {
		try {
			connect.close();

		} catch (Exception ex) {
			// Print an error message if there is an issue closing the connection
			System.out.printf("Error: ", ex.getMessage());
			System.out.println("Error: Unable to close the database connection");

		}

	}

}
