package com.globalin.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {

	public static Connection getConnection() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("연결 실패");
		}

		return null;
	}
	
	
	
	public static void close(PreparedStatement stmt, Connection conn) {

		try {
			if (stmt != null)
				stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			stmt=null;
		}

		try {
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn=null;
		}
			
	}

	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {

		try {
			if (stmt != null)
				stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			stmt=null;
		}

		try {
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn=null;
		}
		
		try {
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			rs=null;
		}
		
	}

}
