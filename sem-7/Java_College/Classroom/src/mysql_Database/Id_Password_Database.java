package mysql_Database;

// imports
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Id_Password_Database {

	public static void main(String[] args) {
		final String DRIVER = "com.mysql.cj.jdbc.Driver"; // JDBC Driver class

		// Database connection details
		final String DBNAME = "JavaCollege"; // Database table name
		final String HOST = "localhost"; // Database server host
		final String DBUSER = "root"; // database Username
		final String DBPASS = "Neupane@11"; // Database password
		final int PORT = 3306; // Database port name
		final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DBNAME; // JDBC connection URL

		// JFrame and UI objects
		JFrame frame = new JFrame("Login Application");
		JLabel name = new JLabel(" Name:");
		JLabel password = new JLabel("Password: ");
		JButton button = new JButton("Submit");

		JTextField textField = new JTextField();
		JPasswordField passfield = new JPasswordField(); // create for passwordField

		// position set Display
		name.setBounds(10, 20, 150, 30); // name label position
		textField.setBounds(100, 20, 100, 30); // name text field position

		password.setBounds(10, 45, 150, 30); // Password name position
		passfield.setBounds(100, 45, 100, 30); // password text field Position

		button.setBounds(80, 100, 70, 50); // Submit Button position

		// Action Listener for Submit
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Retrieve username and password from UI components

					String username = textField.getText();
					char[] passwordChars = passfield.getPassword();
					String password = new String(passwordChars);

					// JDBC connection SETUP
					Class.forName(DRIVER); // Loading Driver
					Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS); // Establish the connection

					// Insert Records
					Statement state = conn.createStatement(); // object create for connection
					String sql = "SELECT * FROM student_profile where username='" + username + "' and password='"
							+ password + "'";
					ResultSet rs = state.executeQuery(sql); // Get all records from table

					// Create an instance
					Display_From_Database tableData = new Display_From_Database();

					if (rs.next()) {
						System.out.println(rs.getInt("id") + "\t \t" + rs.getString("username") + "\t\t"
								+ rs.getString("password"));
						JOptionPane.showMessageDialog(null, "Login successfully", "Success",
								JOptionPane.INFORMATION_MESSAGE);
						tableData.show(); // Display data from database
					} else {
						System.out.println("Invalid login credentials");
						JOptionPane.showMessageDialog(null, "Invalid login credentials", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
					rs.close();
					state.close();
					conn.close();

				} catch (SQLException ex) {
					System.out.println(ex);

				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		// add components to frames
		frame.add(name);
		frame.add(textField);
		frame.add(password);
		frame.add(passfield);
		frame.add(button);

		// Set layout and display settings for the frame
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 250);
		frame.setVisible(true);

	}
}
