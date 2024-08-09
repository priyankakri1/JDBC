package org.placeholder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class loginValidation {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter name ??");
		String name=sc.next();
		System.out.println("Enter password ??");
		String password=sc.next();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String qry="select  username from btm.user where name=? and password=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is loaded and registered");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("Connection established between java and the database");
			pstmt=conn.prepareStatement(qry);
			pstmt.setString(1, name);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String un=rs.getString(1);
				System.out.println("Welcome "+un);
			}
			else {
				System.err.println("Invalid Credentials");
			}
		}
			catch (ClassNotFoundException | SQLException e) {
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


