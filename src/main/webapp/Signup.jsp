<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }
    h1 {
        color: #4CAF50;
    }
    .form-container {
        margin-top: 50px;
        background-color: white;
        padding: 40px;
        border-radius: 8px;
        box-shadow: 0px 0px 10px 0px #ccc;
        width: 50%;
    }
    table {
        margin: 0 auto;
        border-collapse: separate;
        border-spacing: 15px 10px;
        color: #333;
    }
    table td {
        padding: 10px;
    }
    input[type="text"], input[type="email"], input[type="password"] {
        width: 100%;
        padding: 8px;
        margin: 5px 0;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    button[type="submit"] {
        background-color: #4CAF50;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
    }
    button[type="submit"]:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>
    <center>
        <div class="form-container">
            <form action="UserController" method="GET">
                <h1>Sign UP</h1>
                <h2>hello git</h2>
                <br><br>
                <table>
                    <input type="hidden" name="user_id">
                    <tr>
                        <td><b>Name:</b></td>
                        <td><input type="text" name="name" placeholder="Enter your name"></td>
                    </tr>
                    <tr>
                        <td><b>Email:</b></td>
                        <td><input type="email" name="email" placeholder="Enter your email"></td>
                    </tr>
                    <tr>
                        <td><b>Address:</b></td>
                        <td><input type="text" name="address" placeholder="Enter your address"></td>
                    </tr>
                    <tr>
                        <td><b>Contact Number:</b></td>
                        <td><input type="text" name="contact" placeholder="Enter your contact number"></td>
                    </tr>
                    <tr>
                        <td><b>Password:</b></td>
                        <td><input type="password" name="password" placeholder="Enter your password"></td>
                    </tr>
                    <tr>
                        <td><b>Role:</b></td>
                        <td><input type="text" name="role" placeholder="Enter your role"></td>
                    </tr>
                </table>
                <br><br>
                <button type="submit" name="b1" value="signup">Sign Up</button>
            </form>
        </div>
    </center>
</body>
</html>
