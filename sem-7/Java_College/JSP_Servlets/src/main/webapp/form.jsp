<%@ page import="java.sql.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert Data into Database</title>
</head>
<body>
    <!-- Display Parameters -->
    <%= request.getParameter("name") %>
    <%= request.getParameter("address") %>
    <%= request.getParameter("email") %>
    <%= request.getParameter("phone") %>
    <%= request.getParameter("message") %>
    

    <!-- Retrieve Parameters -->
    <%
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String message = request.getParameter("message");
    %>

    <!-- JDBC Connection and Insertion -->
    <%    
    String jdbcUrl = "jdbc:mysql://localhost/JavaCollege";
    Class.forName("com.mysql.cj.jdbc.Driver");


        String dbUser = "root";
        String dbPassword = "Neupane@11";
        // JDBC objects
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // Establish the database connection
            connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);

            // Prepare the SQL statement for insertion
            String sql = "INSERT INTO jsp_servlet (name, address, email, phone, message) VALUES (?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            // Set parameters for the SQL statement
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, address);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, phone);
            preparedStatement.setString(5, message);

            // Execute the insertion
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                out.println("\n Data inserted successfully!");
            } else {
                out.println("Failed to insert data.");
            }

        } catch (Exception e) {
            out.println("\nError: " + e.getMessage());
        } finally {
            // Close resources in the reverse order of their creation
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                out.println("Error closing resources: " + e.getMessage());
            }
        }
    %>
</body>
</html>
