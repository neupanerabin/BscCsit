<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	String name = request.getParameter("uname");
	out.print("Welcome  " + name);
	session.setAttribute("user", name);
	%>
	
	<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	session.setAttribute("username", username);
	session.setAttribute("password", password);

	%>

	<a href="session_tracking_second.jsp">Session Second Tracking</a>



</body>
</html>