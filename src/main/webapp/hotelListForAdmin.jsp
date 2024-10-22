<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="in.mindprove.hotelmanagement.dto.HotelDto" %>
<%@ page import="in.mindprove.hotelmanagement.service.HotelServices" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Available Hotels</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 20px;
    }
    h2 {
        text-align: center;
        color: #333;
    }
    table {
        width: 80%;
        margin: 20px auto;
        border-collapse: collapse;
        background-color: #fff;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }
    th, td {
        padding: 12px 15px;
        text-align: center;
        border: 1px solid #ddd;
    }
    th {
        background-color: #90EE90; /* Light green */
        color: #333;
    }
    td {
        background-color: #f9f9f9; /* Very light gray */
    }
    tr:nth-child(even) td {
        background-color: #e9f5e9; /* Slightly darker light gray for even rows */
    }
    tr:hover td {
        background-color: #d4edda; /* Hover effect */
    }
</style>
</head>
<body>
<h2>List of Available Hotels</h2>

<table border="1">
    <thead>
        <tr>
            <th>Hotel ID</th>
            <th>Hotel Name</th>
            <th>Location</th>
            <th>Hotel Type</th>
            <th>Hotel Payment</th>
        </tr>
    </thead>
    <tbody>
        <%
            HotelServices hotelServices = new HotelServices();
            List<HotelDto> hotels = hotelServices.getAllHotels();
            
            if (hotels != null && !hotels.isEmpty()) {
                for (HotelDto hotel : hotels) {
        %>
        <tr>
            <td><%= hotel.getHotel_id() %></td>
            <td><%= hotel.gethotelname() %></td>
            <td><%= hotel.getHotellocation() %></td>
            <td><%= hotel.getHoteltype() %></td>
            <td><%= hotel.getHotelPayment() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="5">No hotels available.</td>
        </tr>
        <%
            }
        %>
    </tbody>
</table>

</body>
</html>
