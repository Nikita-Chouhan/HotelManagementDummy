<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="in.mindprove.hotelmanagement.dto.roomDto" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Book Your Hotel Room</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
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
            box-shadow: 0px 0px 10px 0px #ccc;
            width: 50%;
            margin: auto;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }

        table th, table td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ddd;
        }

        table th {
            background-color: #f9f9f9;
        }

        input[type="text"], input[type="number"], select {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
            margin-bottom: 10px;
        }

        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        button:hover {
            background-color: #45a049;
        }

        .error {
            color: red;
            font-size: 14px;
        }
    </style>
</head>
<body>

    <center>
        <form action="BookController" method="post">
            <h2>Book Your Room Now</h2>
            
            <table>
                <tr>
                    <input type="hidden" name="user_id" value="<%= request.getParameter("user_id") %>">
                    <input type="hidden" name="hotel_id" value="<%= request.getParameter("hotel_id") %>">
                </tr>

                <tr>
                    <td><b>Rooms</b></td>
                    <td>
                        <select name="totalroom">
                        	<option value="" disabled selected>Select a room</option>
                            <option value="101">101</option>
                            <option value="102">102</option>
                            <option value="103">103</option>
                            <option value="104">104</option>
                            <option value="105">105</option>
                            <option value="201">201</option>
                            <option value="202">202</option>
                            <option value="203">203</option>
                            <option value="204">204</option>
                            <option value="205">205</option>
                            <option value="301">301</option>
                            <option value="302">302</option>
                            <option value="303">303</option>
                            <option value="304">304</option>
                            <option value="305">305</option>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td><b>Members</b></td>
                    <td><input type="number" name="t2"></td>
                </tr>

                <tr>
                    <td><b>Check-In Date</b></td>
                    <td><input type="text" placeholder="yyyy-mm-dd" name="t3"></td>
                </tr>

                <tr>
                    <td><b>Check-out Date</b></td>
                    <td><input type="text" placeholder="yyyy-mm-dd" name="t4"></td>
                </tr>
            </table>

            <button id="Submit" name="action" value="book">Book your room</button>
        </form>

        <%
        List list = (List) request.getAttribute("errorlist");
        if (list != null) {
            for (Iterator it = list.iterator(); it.hasNext();) {
                String error = (String) it.next();
        %>
        <div class="error"><%= error %></div>
        <%
            }
        }
        %>
    </center>

</body>
</html>
