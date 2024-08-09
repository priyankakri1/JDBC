package org.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertMultipleData {
	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		 String qry1="insert into btm.student2 values(104, 'Manish',28)";
		 String qry2="insert into btm.student2 values(105, 'Rakesh',30)";
		 String qry3="insert into btm.student2 values(106, 'Mahesh',38)";
		 
		 
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class is loaded and registered");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("Connection Established with the database Server");
			stmt=conn.createStatement();
			System.out.println("PlatForm Created");
			stmt.executeUpdate(qry1);
			stmt.executeUpdate(qry2);
			stmt.executeUpdate(qry3);
			
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
