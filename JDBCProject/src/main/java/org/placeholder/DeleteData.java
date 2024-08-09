package org.placeholder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteData {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Connection conn=null;
		PreparedStatement pstmt=null;
		String qry="Delete from  btm.employee  where id=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class is loaded and registered");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("Connection Established with the database Server");
			pstmt=conn.prepareStatement(qry);
			System.out.println("Enter the id");
			int id=sc.nextInt();
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			System.out.println("Row deleted");
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
