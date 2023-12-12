package mysql_Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Display_From_Database {

	
    // Method to display data from the database in a JFrame

	void show() {
		JFrame displayFrame = new JFrame("Display Data");
		JTextArea textArea = new JTextArea(20, 40);
		textArea.setEditable(false);

		try {
			
			final String DRIVER = "com.mysql.cj.jdbc.Driver"; // JDBC Driver information

			//Database connection details
			final String DBNAME = "JavaCollege"; // Database table name
			final String HOST = "localhost"; // hosting site
			final String DBUSER = "root"; // database name
			final String DBPASS = "Neupane@11"; // password
			final int PORT = 3306;
			final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DBNAME;

			Class.forName(DRIVER); // Loading Driver
			try (Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS)) {

				// SQL query to retrieve data
				String sql = "SELECT username FROM Login_Check";
				
				// Prepared and execute the SQL statement
				try (PreparedStatement statement = conn.prepareStatement(sql);
						ResultSet resultSet = statement.executeQuery()) {

					// Iterate through the result set and append data to the text area
					while (resultSet.next()) {
						String data = resultSet.getString("username");
						textArea.append(data +"\n");

					}
				}
			} catch (SQLException e) {
				System.out.println("Unable to connect to the database.");
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC driver not found.");
			e.printStackTrace();
		}
		
        // Create a JScrollPane to allow scrolling within the JTextArea
		JScrollPane scrollPane = new JScrollPane(textArea);
		
		displayFrame.add(scrollPane);	   // Add the scroll pane to the JFrame

		displayFrame.setSize(400, 300);
		displayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		displayFrame.setVisible(true);
	}

}
