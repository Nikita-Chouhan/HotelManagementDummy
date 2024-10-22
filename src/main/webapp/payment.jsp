<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Payment for Hotel</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
        }
        
        h2 {
            color: #333;
            margin-top: 20px;
        }
        
        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 400px;
            margin: auto;
            margin-top: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 15px;
        }

        table td {
            padding: 10px;
            text-align: left;
        }

        input[type="text"], input[type="password"], input[type="number"], input[type="month"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
            margin-top: 5px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
            width: 100%;
            margin-top: 10px;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <center>
        <h2>Payment For Your Booked Hotel</h2>
        
        <form action="PaymentController" method="post">
            <table>
                <tr>
                    <td>Cardholder Name:</td>
                    <td><input type="text" name="cardholderName" required /></td>
                </tr>
                <tr>
                    <td>Card Number:</td>
                    <td><input type="text" name="cardNumber" maxlength="16" required /></td>
                </tr>
                <tr>
                    <td>Expiry Date:</td>
                    <td><input type="month" name="expiryDate" required /></td>
                </tr>
                <tr>
                    <td>CVV:</td>
                    <td><input type="password" name="cvv" maxlength="3" required /></td>
                </tr>
                <tr>
                    <td>Amount:</td>
                    <td><input type="number" name="amount" required /></td>
                </tr>
            </table>
            <input type="submit" value="Pay Now"/>
        </form>
    </center>
</body>
</html>
