package org.jsp;

import java.sql.*;

public class fetchAll {
	public static void main(String[] args) {
		Connection conn = null;
		Statement  stmt = null;
		ResultSet rs = null;
		int count = 0;
		String qry = "select * from btm.student2";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is loaded and registered");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("Connection established between java and the database");
			stmt=conn.createStatement();
			rs = stmt.executeQuery(qry);
			
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getInt(3));
				count++;
				System.out.println("==========");
				
			}
			if(count==0) {
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
