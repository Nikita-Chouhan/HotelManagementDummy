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
</head>
<body>
	<h2>List of Booked Hotels</h2>

    <table border="1">
        <thead>
            <tr>
                <th>Booking ID</th>
                <th>user Id</th>
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
            	List<roomDto> bookings = bookServices.getAllBookings();  // Fetch all bookings
                
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
                <td><%= booking.getHotel_id() %></td>
                <td><%= hotel.gethotelname() %></td> <!-- Use "hotel" here instead of "hotelDto" -->
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
                <td colspan="7">No bookings available.</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
