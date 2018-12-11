package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.model.Train;

public class trainDao {
	Connection con;
	// Method which return connection for the database
	private static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName ("oracle.jdbc.OracleDriver");
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
	}
	
	// Method to return train details based on id
	public Train getTrain(int trainno) throws SQLException, ClassNotFoundException {
		
		
		con=getConnection();
		Statement st = con.createStatement();
		Train train=new Train();
		String query="select * from trains where TRAIN_NO='"+trainno+"'";
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			train.setTrainNo(rs.getInt(1));
			train.setTrainName(rs.getString(2));
			train.setSource(rs.getString(3));
			train.setDestination(rs.getString(4));
			train.setTicketPrice(rs.getInt(5));
//			System.out.println(rs.getInt(1)+rs.getString(2)+
//					rs.getString(3)+rs.getString(4)+rs.getDouble(5));
			
		}
		return train;
		
		}
	
}

