package in.mindprove.hotelmanagement.dto;

public class Userdto {

	//private int Id;
	private int user_id;
	private String name;
	private String email;
	private String address;
	private String contactnumber;
	private String password;
	private String role;
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		 this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		 this.address = address;
	}
	public String getcontactumber() {
		return contactnumber;
	}
	public void setcontactnumber(String contactnumber) {
		 this.contactnumber = contactnumber;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
//	public int getId() {
//		return Id;
//	}
//	public void setId(int i) {
//		Id = i;
//	}
	public int getUser_id() {
		return user_id;
	}
	public int setUser_id(int userId) {
		return this.user_id = userId;
	}
	
}
