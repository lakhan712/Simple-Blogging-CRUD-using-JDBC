package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetData {

	private static final String QUERY = "SELECT * FROM register";
	private static Connection conn;
	private static PreparedStatement pst;
	private static ResultSet rs;

	

	public static ArrayList<User> data() {
		conn = Connect.getConnection();
		 ArrayList<User> list = new ArrayList<User>();

		try {
			pst = conn.prepareStatement(QUERY);
			rs = pst.executeQuery();
			while (rs.next()) {
				
				list.add(new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
						rs.getString("email"), rs.getString("mobile")));
			}
			System.out.println("This is List: "+list);
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
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
