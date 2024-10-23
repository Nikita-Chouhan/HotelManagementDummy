<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Hotel</title>
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
        color: #FF0000;
        margin-bottom: 20px;
    }
    label {
        display: block;
        margin-bottom: 10px;
        font-size: 16px;
        color: #333;
    }
    input[type="text"] {
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
        font-size: 16px;
    }
    input[type="submit"] {
        background-color: #FF0000;
        color: white;
        padding: 10px 15px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        width: 100%;
        font-size: 16px;
    }
    input[type="submit"]:hover {
        background-color: #cc0000;
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
    <form action="deleteHotelController" method="post">
        <h2>Delete Your Hotel</h2>
        <label for="hotel_id">Enter Hotel ID to Delete:</label>
        <input type="text" id="hotel_id" name="hotel_id" placeholder="Delete any hotel" required><br><br>
        <input type="submit" name="action" value="Delete">
    </form>
</center>
</body>
</html>
