package org.placeholder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class fetchAll {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement  pstmt = null;
		ResultSet rs = null;
		int count = 0;
		String qry = "select * from btm.employee";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is loaded and registered");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("Connection established between java and the database");
			pstmt=conn.prepareStatement(qry);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println("Id "+rs.getInt(1));
				System.out.println("Name "+rs.getString(2));
				System.out.println("Salary "+rs.getDouble(3));
				System.out.println("Phone "+rs.getLong(4));
				count++;
				System.out.println("==========");
				
			}	if(count==0) {
				System.err.println("Nothing is here");
			}else {
				System.out.println("Total records "+count);
			}
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
