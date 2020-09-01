package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetPosts {
	
	private static final String QUERY = "SELECT * from Post where user_id = ? ";
	private static Connection conn;
	private static PreparedStatement pst;
	private static ResultSet rs;
	
	public static List<Post> getPosts(int userId){
		conn = Connect.getConnection();
		List<Post> list = new ArrayList<Post>();
		try {
			pst = conn.prepareStatement(QUERY);
			pst.setInt(1, userId);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				list.add(new Post(rs.getInt("id"), rs.getString("post"), rs.getInt("likeCount"), rs.getInt("dislikeCount"),userId));
			}
			
			
			System.out.println("returning the actual data list");
			for(Post p: list) {
				System.out.println(p.getId());
				System.out.println(p.getPost());
				System.out.println(p.getLikeCount());
				System.out.println(p.getDislikeCount());
				System.out.println(p.getUserId());
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();

			return null;
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
		
	}

}
