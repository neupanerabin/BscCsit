<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>

<%
    // Establish database connection
    Connection conn = null;
    String url = "jdbc:mysql://localhost:3306/JavaCollege";
    String user = "root";
    String password = "Neupane@11";

    try {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, password);
        Statement statement = conn.createStatement();
        
        // Retrieve form data
        String username = request.getParameter("username");
        String passwordInput = request.getParameter("password");
        
        // Query database for user
        String query = "SELECT * FROM Login_Check WHERE username='" + username + "' AND password='" + passwordInput + "'";
        ResultSet rs = statement.executeQuery(query);
        
        if (rs.next()) {
            // If user exists, forward to success page
            response.sendRedirect("success.jsp");
        } else {
            // If user does not exist, show error
            out.println("Invalid credentials. Please try again.");
        }
        
        rs.close();
        statement.close();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
%>
