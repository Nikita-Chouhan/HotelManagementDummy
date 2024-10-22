package in.mindprove.hotelmanagement.dto;

public class Logindto {
	private int user_id;
	private String email; 
	private String password;

	public String getemail() {
		return email;
	}

	public String setemail(String email) {
		return this.email = email;
	}

	public String getpassword() {
		return password;
	}

	public String setpassword(String password) {
		return this.password = password;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	
}
