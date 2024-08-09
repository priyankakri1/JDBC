package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class updateData {
	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		 String qry="Update btm.student2 set name='Rani' where id=101";
		 
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class is loaded and registered");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("Connection Established with the database Server");
			stmt=conn.createStatement();
			System.out.println("PlatForm Created");
			stmt.executeUpdate(qry);
			System.out.println("Record updated");
			
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
