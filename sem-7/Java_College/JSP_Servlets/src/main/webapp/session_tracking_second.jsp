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
	String name = (String) session.getAttribute("user");
	out.println("Hello " + name);
	%>
	<%
	String username = (String) session.getAttribute("username");
	String password = (String) session.getAttribute("password");
	out.println("\n");
	out.println(" Username:  " + username);
	out.println("Password:  " + password);

	%>

</body>
</html>