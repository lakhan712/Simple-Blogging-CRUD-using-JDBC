package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeletePost {
	private static final String QUERY = "DELETE FROM post where id = ?";
	private static Connection conn;
	private static PreparedStatement pst;
	
	public static boolean deletePost(int id) {
		conn = Connect.getConnection();
		try {
			pst = conn.prepareStatement(QUERY);
			pst.setInt(1, id);
			pst.executeUpdate();
			System.out.println("Post is deleted...");
		
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
