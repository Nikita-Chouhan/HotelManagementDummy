<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		  <%
		String user = (String)session.getAttribute("username");
		if(user!=null)
		{
		out.println(user);
		%>
		<p>Thank For Visiting Our Website</p>
		<%
		}
		session.invalidate();
		%>
		<br>
		<center><a href="Login.jsp">Click Here for Login Again.....!</a>  </center>
</body>
</html>