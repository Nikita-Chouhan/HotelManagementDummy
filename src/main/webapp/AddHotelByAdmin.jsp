<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update table</title>
</head>
<body>
	<center>
		<form action="addHotelController" method="post">
			<br>
			<br>
			<h2>Add Hotel From here</h2>
			<br>
			<input type="hidden" name="hotel_id">
			<br> <input type="text" name="hotelname" placeholder="Hotel Name"><br>
			<br> <input type="text" name="Location" placeholder="Hotel Location"><br>
			<br> <select name="HotelType">
				<option value="" disabled selected>Select a room type</option>
				<option value="AC">AC </option>
				<option value="Non AC">Non AC Rooms</option>
				<option value="AC and Non AC Both">Ac and Non AC Hotel Rooms</option>
			</select> 
			<br><br>
			<input type="text" name="HotelPayment" placeholder="Hotel Payment">
			<input type="text" name="totalrooms" placeholder="total rooms in table">
			
			<button id="submit" name="action" value="Inserted">Add hotel</button>
		</form>
	</center>
</body>
</html>