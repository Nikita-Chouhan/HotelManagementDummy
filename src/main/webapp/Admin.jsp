<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }
    h2 {
        text-align: center;
        margin-top: 20px;
        color: #333;
    }
    nav {
        margin-top: 20px;
        text-align: center;
    }
    nav ul {
        list-style-type: none;
        padding: 0;
        margin: 0;
    }
    nav ul li {
        display: inline-block;
    }
    nav ul li a {
        text-decoration: none;
        color: #fff;
        background-color: #90EE90; /* Light green */
        padding: 10px 15px; /* Reduced padding */
        border-radius: 5px;
        margin: 2px; /* Reduced margin */
        transition: background-color 0.3s ease;
    }
    nav ul li a:hover {
        background-color: #77dd77; /* Slightly darker light green */
    }
    form {
        margin: 0 auto;
        width: 50%;
        padding: 20px;
        background-color: #fff;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        border-radius: 8px;
    }
</style>
</head>
<body>
<form action="adminController" method="post">
    <h2>Admin Dashboard</h2>
    <nav>
        <ul>
            <li><a href="hotelListForAdmin.jsp">All hotels</a></li>
            <li><a href="Allbookings.jsp">All bookings</a></li>
            <li><a href="AddHotelByAdmin.jsp">Add Hotels</a></li>
            <li><a href="DeleteHotelsByAdmin.jsp">Delete Hotels</a></li>
            <li><a href="UpdateHotelByAdmin.jsp">Manage Hotels</a></li>
            <li><a href="LogOut.jsp">Log Out</a></li>
        </ul>
    </nav>
</form>
</body>
</html>
