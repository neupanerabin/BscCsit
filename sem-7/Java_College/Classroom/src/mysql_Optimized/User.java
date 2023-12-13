package mysql_Optimized;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {

	public static void main(String[] args) {
		getUserDetails();
	}

	// Method to fetch and print user details from the database
	public static void getUserDetails() {
		// Create an instance of the Db_Connection class
		Db_Connection databaseConnect = new Db_Connection();

		try {
			// Establish a database connection
			Connection connection = databaseConnect.getConnection();

			// Create a statement for executing SQL queries
			Statement state = connection.createStatement();

			// SQL query to select all records from the 'Student' table
			String sql = "SELECT * FROM Student";

			// Execute the SQL query and obtain the result set
			ResultSet rs = state.executeQuery(sql);

			// Print the header for the result set
			System.out.println("PID\t\t Name\t\tAddress");

			// Iterate through the result set and print each record
			while (rs.next()) {
				System.out.println(rs.getInt("id") + "\t \t" + rs.getString("name") + "\t\t" + rs.getString("address"));
			}

			// Close the result set, statement, and the database connection
			rs.close();
			state.close();
			databaseConnect.CloseConnection();

		} catch (Exception ex) {
			// Print an error message if an exception occurs
			System.out.printf("Error: user", ex.getMessage());
		}
	}
}
