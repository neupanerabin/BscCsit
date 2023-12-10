package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnectionEstablish {
	public static void main(String[] args) {
		//connection
		final String DRIVER = "com.mysql.cj.jdbc.Driver";	// Driver link provided
		
		// 
		final String DBNAME = "JavaCollege";		// Database table name
		final String HOST = "localhost";	// hosting site
		final String DBUSER = "root";	// database name
		final String DBPASS="Neupane@11";	// password
		final int PORT = 3306;
		final String URL="jdbc:mysql://"+HOST+":"+PORT+"/"+DBNAME; 
		try {
			// connection
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, DBUSER, DBPASS);
			conn.close();
			System.out.println("Connect with database successfully");
		}
		catch(SQLException ex){
			System.out.println(ex);
			
		}
		
		catch(Exception ex) {
			System.out.println("Error : "+ex.getMessage());
		}
		
	}

}
