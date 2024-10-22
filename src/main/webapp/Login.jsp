<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f2f2f2;
        margin: 0;
        padding: 0;
    }
    table {
        margin-top: 50px;
        background-color: white;
        border-collapse: collapse;
        box-shadow: 0px 0px 10px 0px #ccc;
    }
    table td {
        padding: 10px;
        text-align: left;
    }
    input[type="text"], input[type="password"] {
        width: 100%;
        padding: 8px;
        margin: 5px 0;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
    }
    input[type="submit"]:hover {
        background-color: #45a049;
    }
    .form-container {
        margin-top: 50px;
    }
    a {
        text-decoration: none;
        color: #4CAF50;
        font-weight: bold;
    }
    a:hover {
        color: #45a049;
    }
    .error {
        color: red;
        font-size: 14px;
    }
</style>
</head>
<body>
  <form action="Login" method="post">
  <center>
  <div class="form-container">
  <table border="1">
      <input type="hidden" name="user_id">
      <tr>
        <td><b>Email:</b></td>
        <td><input type="text" name="email" placeholder="Enter your Email"><br><br></td>
      </tr>
      <tr>
        <td><b>Password:</b></td>
        <td><input type="password" name="password" placeholder="Enter your password"><br><br></td>
      </tr>
      <tr>
        <td colspan="2"><span class="error"></span></td>
      </tr>
    </table>
    <br>
    <input type="submit" name="LOGIN" value="Login">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <br><br>
    <p style="color: red;">If you have no account then...</p>
    <a href="Signup.jsp">SignUp</a> &nbsp;&nbsp;&nbsp;&nbsp;
    <a href="ForgotPassword.jsp">Forgot Password?</a>
  </div>
  </center>
  </form>
</body>
</html>
