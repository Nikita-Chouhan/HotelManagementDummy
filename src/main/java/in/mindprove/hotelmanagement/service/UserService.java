package in.mindprove.hotelmanagement.service;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.mindprove.hotelmanagement.dto.HotelDto;
import in.mindprove.hotelmanagement.dto.Logindto;
import in.mindprove.hotelmanagement.dto.Userdto;
import in.mindprove.hotelmanagement.dto.roomDto;
import in.mindprove.hotelmanagement.util.databaseConnectionUtil;


public class UserService {
	
	
	databaseConnectionUtil db= new databaseConnectionUtil();
	 static Connection con = databaseConnectionUtil.getConnection();
	   

	
//	public boolean isEmailUnique(String email) {
//	    boolean isUnique = true;
//
//	    try {
//	        PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) FROM user WHERE email = ?");
//	        ps.setString(1, email);
//	        ResultSet rs = ps.executeQuery();
//	        if (rs.next()) {
//	            int count = rs.getInt(1);
//	            if (count > 0) {
//	                isUnique = false; 
//	            }
//	        }
//	    } catch (SQLException e) {
//	        System.out.print("Error in SQL statement for checking email uniqueness.");
//	        e.printStackTrace();
//	    }
//
//	    return isUnique;
//	}



	public int saveSignUpInfo(Userdto s) {
	    int x = 0;

	    try {
	        
//	        if (!isEmailUnique(s.getemail())) {
//	            System.out.println("Error: Email already exists. Registration failed.");
//	            return x; 
//	        }

	        // Proceed with inserting the user if the email is unique
	        PreparedStatement ps = con.prepareStatement("INSERT INTO user (user_id,name, email,address,contactnumber, password,role) VALUES(?,?,?,?,?,?,?)");

	      //  ps.setLong(1,s.getId());
	        ps.setInt(1,s.getUser_id());
	        ps.setString(2, s.getname());
	        ps.setString(3, s.getemail());
	        ps.setString(4, s.getAddress());
	        ps.setString(5, s.getcontactumber());
	        ps.setString(6, s.getpassword());
	        ps.setString(7, s.getRole());

	        x = ps.executeUpdate();
	        if (x > 0) {
	            System.out.println("Success: User registered.");
	        } else {
	            System.out.println("Error: Registration failed.");
	        }

	    } catch (SQLException e) {
	        System.out.print("Error in SQL statements during registration.");
	        e.printStackTrace();
	    }

	    return x;
	}
	


	public boolean SaveLoginInfo(Logindto u) {
		boolean isValid = false;
		try {
			 
			PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE user_id = ? AND email = ? AND password = ?"+ "");
			ps.setInt(1, u.getUser_id());
			ps.setString(2, u.getemail());
			ps.setString(3, u.getpassword());
			ResultSet rs = ps.executeQuery();
			if (rs.next() == true) {
				isValid = true;
			} else {
				isValid = false;
			}
			 
			
		} catch (SQLException e) {
			System.out.print("Error in sql statements");
		}
		return isValid;

	}
    public static List<Userdto> getAllLogins() {
        List<Userdto> LoginsList = new ArrayList<>();
        try {
            String query = "SELECT * FROM user";
            PreparedStatement stmt = con.prepareStatement(query);
           
            
            ResultSet rs = stmt.executeQuery();

            
            while (rs.next()) {
            	int int1 = rs.getInt("user_id");
            	String string = rs.getString("name");
            	String string2 = rs.getString("email");
            	String string3 = rs.getString("address");
            	String string4=rs.getString("contactnumber");
            	String string5=rs.getString("password");
            	String string6=rs.getString("role");
            	 
            	Userdto userdto=new Userdto();
            	userdto.setUser_id(int1);
            	userdto.setname(string);
            	userdto.setemail(string2);
            	userdto.setAddress(string3);
            	userdto.setcontactnumber(string4);
            	userdto.setpassword(string5);
            	userdto.setRole(string6);
            	
            	LoginsList.add(userdto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return LoginsList;

    }

	
public static Userdto getuserById(int user_id) {
        Userdto user = null;
        Userdto u= new Userdto();
      //  int resultset=0;
       try (Connection con = databaseConnectionUtil.getConnection()) {
           String query = "SELECT user_id  FROM user WHERE email=? and password=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, user_id);
            System.out.println(user_id);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
               user = new Userdto();
                user.setUser_id(rs.getInt("user_id"));            
            }
            } catch (SQLException e) {
           e.printStackTrace();
        }

	return user;
   }



	

	    // Method to validate user by email and password
	    public static Userdto getUserByEmailAndPassword(String email, String password) {
	        Userdto user = null;
	        Connection conn = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;

	        try {
	            conn = databaseConnectionUtil.getConnection();
	            String sql = "SELECT user_id FROM user WHERE email = ? AND password = ?";
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, email);
	            stmt.setString(2, password);

	            rs = stmt.executeQuery();

	            if (rs.next()) {
	                user = new Userdto();
	                user.setUser_id(rs.getInt("user_id"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	       
	        }

	        return user;  	    }
	
}

    

	
	
