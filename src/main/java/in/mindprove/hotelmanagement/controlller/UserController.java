package in.mindprove.hotelmanagement.controlller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.mindprove.hotelmanagement.dto.Userdto;
import in.mindprove.hotelmanagement.service.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/UserController")
public class UserController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String target = "/Signup.jsp";
		boolean hasErrors = false;
		
		// Input validations
		String userIdStr = request.getParameter("user_id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		String password = request.getParameter("password");
		String role = request.getParameter("role");

		List<String> errors = new LinkedList<>();

		
		if (name == null || name.isEmpty()) {
			errors.add("Name is required.");
		}

		if (!isValidEmail(email)) {
			errors.add("Invalid email format.");
		}

		if (address == null || address.isEmpty()) {
			errors.add("Address is required.");
		}

		if (!isValidContact(contact)) {
			errors.add("Invalid contact number. Must be 10 digits.");
		}

		if (password == null || password.length() < 6) {
			errors.add("Password must be at least 6 characters long.");
		}

		if (!errors.isEmpty()) {
			request.setAttribute("errors", errors);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(target);
			rd.forward(request, response);
			return;
		}

		// If no errors, proceed with saving user info
		Userdto u = new Userdto();
		u.setname(name);
		u.setemail(email);
		u.setAddress(address);
		u.setcontactnumber(contact);
		u.setpassword(password);
		u.setRole(role);

		UserService db = new UserService();
		int x = db.saveSignUpInfo(u);

		if (x >= 1) {
			request.setAttribute("sms", "Signup Successfully");
			target = "/Index.jsp";
		} else {
			request.setAttribute("sms", "Error during signup.");
			target = "/Signup.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(target);
		rd.forward(request, response);
		
		
	}

	// Method to validate email using regex
	private boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		Pattern pattern = Pattern.compile(emailRegex);
		if (email == null) {
			return false;
		}
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	// Method to validate contact number (e.g., should be 10 digits)
	private boolean isValidContact(String contact) {
		String contactRegex = "\\d{10}";
		Pattern pattern = Pattern.compile(contactRegex);
		if (contact == null) {
			return false;
		}
		Matcher matcher = pattern.matcher(contact);
		return matcher.matches();
	}
}
