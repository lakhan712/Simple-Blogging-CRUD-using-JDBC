package model;

import java.sql.*;

public class Connect {
	
	private static Connection conn=null;
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/USER";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root123";// root123
	
	
//	static Statement st;
//	static ResultSet rs;
	
	public static Connection getConnection() {
		
		try {
			Class.forName(DRIVER);
			 conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			 System.out.println("Connection Successfull");
			
			return conn;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Something went wrong...");
			return conn;
		}
		
	}
	

}
