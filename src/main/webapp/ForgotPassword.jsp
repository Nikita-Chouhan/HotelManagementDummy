<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <form action="ForgotPassworController" method="post">
    <center>
      <h2>Forgot Password</h2>
      <table>
        <tr>
          <td><b>Email:-</b></td>
          <td><input type="text" name="email" placeholder="Enter your registered Email"><br><br></td>
          <td><input type="password" name="password" placeholder="Enter your new password"><br><br>
        </tr>
      </table>
      <br>
      <input type="submit" value="Reset Password">
    </center>
  </form>
</body>
</html>
