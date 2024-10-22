<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update from here</title>
</head>
<body>
<center>
		<form action="UpdateHotelController" method ="post">
		<br><br><br><br><br>
		<label for="hotel_id">Enter Hotel ID to Update:</label><br>
 		<input type="text" id="hotel_id"  name="hotel_id" placeholder="Delete any hotel"><br><br>		
 		<input type="text" name="HotelName" placeholder="Hotel Name"><br>
		
			<br> <input type="text" name="Location" placeholder="Hotel Location"><br>
			<br> <select name="HotelType">
			<option value="" disabled selected>Select a room type</option>
				<option value="AC">AC </option>
				<option value="Non AC">Non AC Rooms</option>
				<option value="AC and Non AC Both">Ac and Non AC Hotel Rooms</option></select><br><br>
				<input type="text" name="HotelPayment" placeholder="Hotel Payment"><br><br>
				<input type="text" name="totalrooms" placeholder="total rooms in table">
				
				
				<br><br>
 		   <input type="Submit" name="action"  value="Updated">
 		</form>
 	</center>
</body>
</html>