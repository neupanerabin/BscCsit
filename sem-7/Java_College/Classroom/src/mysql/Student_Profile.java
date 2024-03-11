package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Student_Profile {
	final String DRIVER = "com.mysql.cj.jdbc.Driver"; // Driver link provided

	// Database connection details
	final static String DBNAME = "JavaCollege"; // Database table name
	final static String HOST = "localhost"; // Database server host
	final static String DBUSER = "root"; // database Username
	final static String DBPASS = "Neupane@11"; // Database password
	final static int PORT = 3306; // Database port name
	final static String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DBNAME; // JDBC connection URL

	// JDBC variables for opening and managing connection
	private static Connection connection;
	private static Statement statement;

	public static void main(String[] args) {
		try {
			// Open a connection
			connection = DriverManager.getConnection(URL, DBUSER, DBPASS);
			System.out.println("Connected to the database");

			// Insert sample data into student_profile
			insertSampleData();

			// Select and display data from student_profile table
			selectAndDisplayData();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// Insert sample data into student_profile
	private static void insertSampleData() throws SQLException {
		statement = connection.createStatement();
		String insertDataSQL = "INSERT INTO student_profile ( username, password) VALUES " + 
				"( 'robs', 'robs'),"
				+ "( 'giri', 'khadka')," + 
				"( 'sanghu', 'paks')";

		statement.executeUpdate(insertDataSQL);
		System.out.println("Sample data inserted into student_profile");
	}

	// Select and display data from student_profile table
	private static void selectAndDisplayData() throws SQLException {
		statement = connection.createStatement();
		String selectDataSQL = "SELECT * FROM student_profile";
		ResultSet resultSet = statement.executeQuery(selectDataSQL);

		System.out.println("\nStudent Profiles:");
		System.out.println("ID\tUsername\tPassword");
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String username = resultSet.getString("username");
			String password = resultSet.getString("password");
			System.out.println(id + "\t" + username + "\t\t" + password);
		}
	}
}
