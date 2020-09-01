package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthenticationService {
	private static User user = new User();
	private static final String QUERY = "SELECT * FROM register where username = ? and password = ?";
	private static Connection conn;
	private static PreparedStatement pst;
	private static ResultSet rs;
	
	public static boolean valideateUser(String username, String password) {
		conn = Connect.getConnection();
		
		try {
			pst = conn.prepareStatement(QUERY);
			pst.setString(1, username);
			pst.setString(2, password);
			rs = pst.executeQuery();
			
			
			if(rs.next()) {
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setMobile(rs.getString("mobile"));
			}else {
				return false;
			}
			
		
		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
			
		}finally {
			try {
				pst.close();
				rs.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(user==null) {
			//System.out.println("if null:  "+user);
			return false;
		}else {
			System.out.println("Auth is correct...");
			//System.out.println("if having value:  "+user);
			return true;
		}
	}
	
	public static User getUser() {
		return user;
	}
	
	
	
}
