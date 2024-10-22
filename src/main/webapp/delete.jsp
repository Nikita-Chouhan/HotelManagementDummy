
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>delete Your Hotel Room</title>
</head>
<body>
	<center>
		<h1>Delete Your Room</h1>s
		<form action="deleteServices" method="post">
			<h2>delete your Place Now</h2>
			<table border="2.4">
				<tr>

					<b>Which room you want to delete</b>
     <tr>	
                <td><b>Rooms</b>
                <td>
               
				<select name="totalroom">
				<option value="" disabled selected>Select a room</option>
				<option value="101">101 </option>
				<option value="102">102</option>
				<option value="101">103</option>
				<option value="102">104</option>
				<option value="101">105 </option>
				<option value="102">201</option>
				<option value="101">202 </option>
				<option value="102">203</option>
				<option value="101">204 </option>
				<option value="102">205</option>
				<option value="101">301 </option>
				<option value="102">302</option>
				<option value="102">303</option>
				<option value="101">304 </option>
				<option value="101">305 </option></td>
			</select> 
		</tr><br></td>
				</tr>
				<tr>
					<td><b>Memebers</b></td>
					<td><input type="number" name="t2"><br> <br></td>
				</tr>
				<tr>
					<td><b>Check-In Date</b></td>
					<td><input type="text" placeholder="yyyy-mm-dd" name="t3"><br>
						<br></td>
				<tr>
					<td><b>Check-out Date</b></td>
					<td><input type="text" placeholder="yyyy-mm-dd" name="t4"><br>
						<br></td>
				</tr>
			</table>
			<br> <br>
			<button id="Submit" name="action" value="Delete">delete your
				room</button>
			&nbsp&nbsp&nbsp&nbsp


		</form>
	</center>
</body>
</html>
</body>
</html>