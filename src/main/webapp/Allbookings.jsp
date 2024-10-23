<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import=" in.mindprove.hotelmanagement.service.bookingService"%>
<%@ page import=" in.mindprove.hotelmanagement.dto.roomDto"%>
<%@ page import="java.util.List" %>
<%@ page import="in.mindprove.hotelmanagement.dto.HotelDto" %>
<%@ page import="in.mindprove.hotelmanagement.service.HotelServices" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Booked Hotels</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
        background-color: #f4f4f4;
    }
    h2 {
        color: #333;
        text-align: center;
    }
    table {
        width: 80%;
        margin: 20px auto;
        border-collapse: collapse;
        background-color: #fff;
        box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
    }
    th, td {
        padding: 12px 15px;
        text-align: center;
        border: 1px solid #ddd;
    }
    th {
        background-color: #007BFF;
        color: white;
    }
    tr:nth-child(even) {
        background-color: #f2f2f2;
    }
    tr:hover {
        background-color: #f1c40f;
        color: #fff;
    }
    td {
        color: #555;
    }
</style>
</head>
<body>
    <h2>List of Booked Hotels</h2>

    <table>
        <thead>
            <tr>
                <th>Booking ID</th>
                <th>User ID</th>
                <th>Hotel ID</th>
                <th>Hotel Name</th>
                <th>Room Number</th>
                <th>Capacity</th>
                <th>Check-in</th>
                <th>Check-out</th>
            </tr>
        </thead>
        <tbody>
            <%
                bookingService bookServices = new bookingService();
                List<roomDto> bookings = bookServices.getAllBookings();  
                
                HotelServices hotelServices = new HotelServices();
                List<HotelDto> hotels = hotelServices.getAllHotels();
                
                // Iterate over the bookings list
                if (bookings != null && !bookings.isEmpty()) {
                    for (roomDto booking : bookings) {
                        if (hotels != null && !hotels.isEmpty()) {
                            for (HotelDto hotel : hotels) {
                                if (hotel.getHotel_id() == booking.getHotel_id()) {  // Match the hotel with booking
            %>
            <tr>
                <td><%= booking.getBooking_id() %></td>
                <td><%= booking.getUser_id() %></td>
                <td><%= booking.getHotel_id() %></td>
                <td><%= hotel.gethotelname() %></td>
                <td><%= booking.getRoomnumber() %></td>
                <td><%= booking.getcapacity() %></td>
                <td><%= booking.getcheckin() %></td>
                <td><%= booking.getcheckout()%></td>
            </tr>
            <%
                                }
                            }
                        }
                    }
                } else {
            %>
            <tr>
                <td colspan="8">No bookings available.</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
