<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Hotel</title>
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
        width: 400px;
        margin-top: 50px;
    }
    h2 {
        color: #007BFF;
        margin-bottom: 20px;
    }
    label {
        display: block;
        margin-bottom: 10px;
        font-size: 16px;
        color: #333;
    }
    input[type="text"], select {
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
        font-size: 16px;
    }
    input[type="submit"] {
        background-color: #28a745;
        color: white;
        padding: 10px 15px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        width: 100%;
        font-size: 16px;
    }
    input[type="submit"]:hover {
        background-color: #218838;
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
    <form action="UpdateHotelController" method="post">
        <h2>Update Hotel Details</h2>
        <label for="hotel_id">Enter Hotel ID to Update:</label>
        <input type="text" id="hotel_id" name="hotel_id" placeholder="Enter Hotel ID" required><br>
        <input type="text" name="HotelName" placeholder="Hotel Name" required><br>
        <input type="text" name="Location" placeholder="Hotel Location" required><br>
        <select name="HotelType" required>
            <option value="" disabled selected>Select a room type</option>
            <option value="AC">AC</option>
            <option value="Non AC">Non AC Rooms</option>
            <option value="AC and Non AC Both">AC and Non AC Hotel Rooms</option>
        </select><br><br>
        <input type="text" name="HotelPayment" placeholder="Hotel Payment" required><br>
        <input type="text" name="totalrooms" placeholder="Total Rooms" required><br><br>
        <input type="submit" name="action" value="Updated">
    </form>
</center>
</body>
</html>
