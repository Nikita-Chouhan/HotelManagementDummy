<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Table - Add Hotel</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }
    form {
        background-color: #fff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        width: 350px;
        margin-top: 50px;
    }
    h2 {
        color: #007BFF;
        margin-bottom: 20px;
    }
    input[type="text"], select {
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
        font-size: 16px;
    }
    button {
        background-color: #007BFF;
        color: white;
        padding: 10px 15px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        width: 100%;
        font-size: 16px;
    }
    button:hover {
        background-color: #0056b3;
    }
    center {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
</style>
</head>
<body>
	<center>
		<form action="addHotelController" method="post">
			<h2>Add Hotel Here</h2>
			<input type="hidden" name="hotel_id">
			<input type="text" name="hotelname" placeholder="Hotel Name" required>
			<input type="text" name="Location" placeholder="Hotel Location" required>
			<select name="HotelType" required>
				<option value="" disabled selected>Select a room type</option>
				<option value="AC">AC</option>
				<option value="Non AC">Non AC Rooms</option>
				<option value="AC and Non AC Both">AC and Non AC Hotel Rooms</option>
			</select>
			<input type="text" name="HotelPayment" placeholder="Hotel Payment" required>
			<input type="text" name="totalrooms" placeholder="Total Rooms" required>
			<button id="submit" name="action" value="Inserted">Add Hotel</button>
		</form>
	</center>
</body>
</html>
