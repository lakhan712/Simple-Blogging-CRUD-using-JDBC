package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterService {

	private static final String QUERY = "INSERT INTO register (username, password , email, mobile) values(?, ?, ?, ?)";
	private static PreparedStatement pst;
	private static Connection conn;

	public static void register(User user) {

		try {
		 
			conn = Connect.getConnection();
			pst = conn.prepareStatement(QUERY);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getEmail());
			pst.setString(4, user.getMobile());

			pst.executeUpdate();
			System.out.println("Data is inserted...");

		} catch (Exception e) {
			System.out.println("Data is not inserted...");
			System.out.println(e);
		} finally {
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
