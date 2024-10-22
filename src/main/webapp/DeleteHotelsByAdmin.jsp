<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>delete here</title>
</head>
<body>
<center>
		<form action="deleteHotelController" method ="post">
		<br><br><br><br><br>
		<h2>delete your hotel</h2>
		<label for="hotel_id">Enter Hotel ID to Delete:</label>
 		<input type="text" id="hotel_id"  name="hotel_id" placeholder="Delete any hotel"><br><br>
 		<input type="submit" name="action" value="Delete">
 		</form>
 	</center>
</body>
</html>