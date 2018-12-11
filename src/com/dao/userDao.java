package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class userDao {

	Connection con;
	// Method which return connection for the database
	private static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName ("oracle.jdbc.OracleDriver");
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
	}
	
	// method to check for login credentials
	public boolean validateUser(String username,String password) throws SQLException {
		try {
			con=getConnection();
			Statement st = con.createStatement();
			String query="select count(*) from reg_users where username='"+username+"' and password ='"+password+"'";
			System.out.println(query);
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				if(rs.getString	(1).equals("1")){
					return true;
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			con.close();
		}
		
		return false;
		
	}
	
	// method to register user in the database
	public int register(String username,String password,String email) throws SQLException {
		try {
			con=getConnection();
			Statement state = con.createStatement();
			int input = state.executeUpdate("insert into reg_users values('" + username+"','"+ password+"','"+email+"')");
			return input;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			con.close();
		}
		return 0;
	}
	
	
}
