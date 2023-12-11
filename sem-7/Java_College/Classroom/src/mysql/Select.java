package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {
	public static void main(String[] args) {
		// connection
		final String DRIVER = "com.mysql.cj.jdbc.Driver"; // Driver link provided

		//
		final String DBNAME = "JavaCollege"; // Database table name
		final String HOST = "localhost"; // hosting site
		final String DBUSER = "root"; // database name
		final String DBPASS = "Neupane@11"; // password
		final int PORT = 3306;
		final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DBNAME;
		try {
			// connection
			Class.forName(DRIVER); // Loading Driver
			Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS); // request for connection

			// Insert Records
			Statement state = conn.createStatement(); // object create for connection
			String sql = "SELECT * FROM Student";
			ResultSet rs = state.executeQuery(sql); // Get all records from table
			System.out.println("PID\t\t Name\t\tAddress");

			while (rs.next()) {
				System.out
						.println(rs.getInt("id") + "\t \t" + rs.getString("name") + "\t\t" + rs.getString("address"));
			}
			rs.close();
			state.close();
			conn.close();

			System.out.print("Display all records successfully");

		} catch (SQLException ex) {
			System.out.println(ex);

		}

		catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}

	}

}
