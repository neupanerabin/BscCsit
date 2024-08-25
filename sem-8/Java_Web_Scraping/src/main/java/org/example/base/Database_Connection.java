package org.example.base;


/*
 * @author : rabin
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database_Connection {

    // Database URL, username, and password
    private static final String URL = "jdbc:mysql://localhost:3306/Web_Scraping"; // Update with your database URL
    private static final String USER = "rabin"; // Update with your database username
    private static final String PASSWORD = "**********"; // Update with your database password

    // Database connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
