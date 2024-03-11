<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>

<%
    // Retrieve username and password from the form
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    // Check if the credentials match those stored in the database (replace with your database logic)
    boolean isValidUser = checkCredentials(username, password);

    if (isValidUser) {
        // Redirect to the success page if credentials are valid
        response.sendRedirect("success.jsp");
    } else {
        // Redirect to the error page if credentials are invalid
        response.sendRedirect("error.jsp");
    }
%>

<%
    // Function to check credentials (replace with your database logic)
    boolean checkCredentials(String username, String password) {
        // Database connection parameters
        String dbUrl = "jdbc:mysql://localhost:3306/JavaCollege";
        Class.forName("com.mysql.cj.jdbc.Driver");

        String dbUsername = "root";
        String dbPassword = "Neupane@11";

        try {
            // Establish database connection
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

            // Prepare SQL query to check credentials
            String sql = "SELECT * FROM jsp_login WHERE username=? AND password=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            // Execute query
            ResultSet resultSet = statement.executeQuery();

            // Check if any rows are returned
            if (resultSet.next()) {
                // If a row is returned, credentials are valid
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
%>
