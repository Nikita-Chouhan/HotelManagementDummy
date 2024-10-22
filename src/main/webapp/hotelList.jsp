<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="in.mindprove.hotelmanagement.dto.HotelDto"%>
<%@ page import="in.mindprove.hotelmanagement.dto.Userdto"%>
<%@ page import="in.mindprove.hotelmanagement.service.HotelServices"%>
<%@ page import="in.mindprove.hotelmanagement.service.UserService"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Available Hotels</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f9f9f9;
        margin: 0;
        padding: 0;
    }
    h2 {
        text-align: center;
        color: #333;
        margin-top: 20px;
    }
    table {
        width: 80%;
        margin: 20px auto;
        border-collapse: collapse;
        box-shadow: 0px 0px 10px 0px #ccc;
        background-color: #fff;
    }
    table th, table td {
        padding: 12px;
        text-align: center;
        border: 1px solid #ddd;
    }
    table th {
        background-color: #f2f2f2;
        color: #333;
    }
    table td {
        color: #555;
    }
    a {
        background-color: #87CEEB;
        color: white;
        padding: 8px 12px;
        text-decoration: none;
        border-radius: 4px;
        transition: background-color 0.3s;
    }
    a:hover {
        background-color: #5f9ea0;
    }
    tr:nth-child(even) {
        background-color: #f9f9f9;
    }
    tr:hover {
        background-color: #f1f1f1;
    }
    .no-hotels {
        text-align: center;
        color: #d9534f;
        font-size: 18px;
    }
</style>
</head>
<body>
    <h2>List of Available Hotels</h2>

    <table>
        <thead>
            <tr>
                <th>Hotel ID</th>
                <th>Hotel Name</th>
                <th>Location</th>
                <th>Hotel Type</th>
                <th>Hotel Payment per night</th>
                <th>Book</th>
            </tr>
        </thead>
        <tbody>
            <%
                HotelServices hotelServices = new HotelServices();
                List<HotelDto> hotels = hotelServices.getAllHotels();
                
                if (hotels != null && !hotels.isEmpty()) {
                   
                	UserService userservices = new UserService();
                    List<Userdto> users = userservices.getAllLogins();
                    if (users != null && !users.isEmpty()) {
                        
                    	Userdto user = users.get(0);
                    	
                        for (HotelDto hotel : hotels) {
            %>
            <tr>
                <td><%= hotel.getHotel_id() %></td>
                <td><%= hotel.gethotelname() %></td>
                <td><%= hotel.getHotellocation() %></td>
                <td><%= hotel.getHoteltype() %></td>
                <td><%= hotel.getHotelPayment() %></td>
                <td><a href="Book.jsp?hotel_id=<%= hotel.getHotel_id() %>&user_id=<%= user.getUser_id() %>">Book Now</a></td>
            </tr>
            <%
                        }
                    }
                } else {
            %>
            <tr>
                <td colspan="6" class="no-hotels">No hotels available.</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
