package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateService {
	private static final String QUERY = "UPDATE post set post=? where id=?";
			
	private static Connection conn;
	private static PreparedStatement pst;
	private static ResultSet rs;
	
	public static boolean updatePost(String post, int id) {
		conn = Connect.getConnection();
		try {
			pst = conn.prepareStatement(QUERY);
			pst.setString(1, post);
			pst.setInt(2, id);
			pst.executeUpdate();
			System.out.println("Post is updated...");
		
		return true;
		}catch(Exception e) {
			System.out.println("we are in catch block");
			System.out.println(e);
			e.printStackTrace();
			return false;
		}finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
