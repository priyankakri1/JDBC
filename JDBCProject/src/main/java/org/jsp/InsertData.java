package org.jsp;

import java.sql.*;

public class InsertData {
	public static void main(String[] args) {
	Connection conn=null;
	Statement stmt=null;
	 String qry="insert into btm.student2 values(104,'Priya',29)";
	 
	 try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver class is loaded and registered");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
		System.out.println("Connection Established with the database Server");
		stmt=conn.createStatement();
		System.out.println("PlatForm Created");
		stmt.executeUpdate(qry);
		System.out.println("Record Inserted");
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 finally {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	 
	}
}
