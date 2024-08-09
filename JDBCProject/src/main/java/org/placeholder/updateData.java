package org.placeholder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class updateData {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Connection conn=null;
		PreparedStatement pstmt=null;
		String qry="Update btm.employee set name=?,salary=?,phone=? where id=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class is loaded and registered");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("Connection Established with the database Server");
			pstmt=conn.prepareStatement(qry);
			System.out.println("Enter the id");
			int id=sc.nextInt();
			System.out.println("Enter the name");
			String name=sc.next();
			System.out.println("Enter the salary");
			double salary=sc.nextDouble();
			System.out.println("Enter the phonne");
			long phone=sc.nextLong();
			pstmt.setString(1, name);
			pstmt.setDouble(2, salary);
			pstmt.setLong(3, phone);
			pstmt.setLong(4, id);
			
			pstmt.executeUpdate();
			System.out.println("Record updated");
			
		}  catch (ClassNotFoundException | SQLException e) {
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
				if(pstmt!=null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
	}

}
