package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostService {
	
	private static final String QUERY = "INSERT INTO post(post, likeCount, dislikeCount, user_id) "
			+ "values(?, ?, ?, ?)";
	private static Connection conn;
	private static PreparedStatement pst;
	private static ResultSet rs;
	
	public static boolean createPost(String post, int userId) {
		conn = Connect.getConnection();
		try {
			pst = conn.prepareStatement(QUERY);
			pst.setString(1, post);
			pst.setInt(2, 50);
			pst.setInt(3, 10);
			pst.setInt(4, userId);
			pst.executeUpdate();
			System.out.println("Post is inserted...");
		
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
