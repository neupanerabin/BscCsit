<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <!-- Retrieve form parameters -->
    <%
    String name = request.getParameter("name");
    String address = request.getParameter("address");
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");
    String message = request.getParameter("message");
    %>

    <h2>
        <!-- Import necessary Java packages -->
        <%@ page import="java.sql.*" %>
        
        <!-- Attempt to insert data into the database -->
        <%
        try {
            // Establish a database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/JavaCollege", "root", "Neupane@11");

            // Create a prepared statement with parameterized query
            String sql = "INSERT INTO jsp_servlet (name, address, email, phone, message) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                // Set parameter values
                pstmt.setString(1, name);
                pstmt.setString(2, address);
                pstmt.setString(3, email);
                pstmt.setString(4, phone);
                pstmt.setString(5, message);

                // Execute the update
                pstmt.executeUpdate();
                out.println("Data added successfully");
            }
        } catch (SQLException e) {
            // Handle any database-related errors
            out.println("Error: " + e.getMessage());
        }
        %>
    </h2>
</body>
</html>
