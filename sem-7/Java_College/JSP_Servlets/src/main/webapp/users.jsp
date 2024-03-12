<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<%
    Connection conn = null;
String url = "jdbc:mysql://localhost:3306/JavaCollege";
String user = "root";
String password = "Neupane@11";

    try {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, password);
        Statement statement = conn.createStatement();
        
        // Query database for all users
        String query = "SELECT * FROM Login_Check";
        ResultSet rs = statement.executeQuery(query);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User List</title>
</head>
<body>
    <h2>User List</h2>
    <table border="1">
        <tr>
            <th>Username</th>
            <th>Password</th>
        </tr>
        <% while(rs.next()) { %>
        <tr>
            <td><%= rs.getString("username") %></td>
            <td><%= rs.getString("password") %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
<%
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
