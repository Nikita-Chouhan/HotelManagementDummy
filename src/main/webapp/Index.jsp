<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hotel Management Project</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }
    h3 {
        color: #333;
        font-size: 28px;
        margin-top: 50px;
    }
    nav {
        margin-top: 30px;
        background-color: #333;
        padding: 15px;
        border-radius: 8px;
        display: inline-block;
    }
    nav a {
        text-decoration: none;
        color: white;
        padding: 10px 20px;
        font-weight: bold;
        background-color: #87CEEB; /* Light blue color */
        border-radius: 4px;
        transition: background-color 0.3s;
        margin-right: 15px;
    }
    nav a:hover {
        background-color: #ADD8E6; /* Lighter blue on hover */
    }
    nav a:last-child {
        margin-right: 0;
    }
</style>
</head>
<body>
    <center>
        <h3><b>HOTEL MANAGEMENT SYSTEM</b></h3>
        <nav>
            <a href="hotelList.jsp">All Hotels</a>
            <!-- <a href="Book.jsp">Book Your Room</a> -->
            <a href="delete.jsp">Delete Your Room</a>
            <a href="update.jsp">Update Your Room</a>
            <a href="LogOut.jsp">LogOut</a>
        </nav>
    </center>
</body>
</html>
