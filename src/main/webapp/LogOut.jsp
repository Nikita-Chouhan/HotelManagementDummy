<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Session Page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }
    .container {
        background-color: #fff;
        border-radius: 10px;
        padding: 40px;
        margin: 100px auto;
        text-align: center;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        max-width: 400px;
    }
    h2 {
        color: #333;
        margin-bottom: 20px;
    }
    p {
        font-size: 18px;
        color: #666;
        margin-bottom: 20px;
    }
    a {
        text-decoration: none;
        color: #007BFF;
        font-size: 16px;
        border: 1px solid #007BFF;
        padding: 10px 20px;
        border-radius: 5px;
        transition: background-color 0.3s ease, color 0.3s ease;
    }
    a:hover {
        background-color: #007BFF;
        color: white;
    }
</style>
</head>
<body>
    <div class="container">
        <%
            String user = (String)session.getAttribute("username");
            if(user != null) {
                out.println("<h2>Welcome, " + user + "!</h2>");
        %>
        <p>Thank you for visiting our website.</p>
        <%
            }
            session.invalidate();
        %>
        <br>
        <a href="Login.jsp">Click Here to Login Again</a>
    </div>
</body>
</html>
