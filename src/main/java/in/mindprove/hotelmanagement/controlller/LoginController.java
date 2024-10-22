package in.mindprove.hotelmanagement.controlller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.mindprove.hotelmanagement.dto.Logindto;
import in.mindprove.hotelmanagement.dto.Userdto;
import in.mindprove.hotelmanagement.service.UserService;
import in.mindprove.hotelmanagement.util.databaseConnectionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login")
public class LoginController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("email");
		String password = request.getParameter("password");

		UserService userservice = new UserService();
		Logindto u = new Logindto();

		u.setemail(username);
		u.setpassword(password);

		try (Connection conn = databaseConnectionUtil.getConnection()) {
			String query = "SELECT role FROM user WHERE email=? AND password=?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String role = rs.getString("role");
				HttpSession session = request.getSession(false);

				if (session != null) {
					session.invalidate();
				}
				session = request.getSession(true);
				session.setAttribute(username, password);
				session.setAttribute("role", role);

				// if (role.equalsIgnoreCase("ADMIN"))
				if (username.equals(username) && password.equals(password) && role.equals("ADMIN")) {
					response.sendRedirect("Admin.jsp");
				} else if (username.equals(username) && password.equals(password) && role.equals("MANAGER")) {
					response.sendRedirect("Manager.jsp");
				} else if (username.equals(username) && password.equals(password) && role.equals("USER")) {
					response.sendRedirect("Index.jsp");
				}
			} else {
				response.sendRedirect("Login.jsp?error=Invalid Credentials");
				System.out.println("wrong passwrod");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
