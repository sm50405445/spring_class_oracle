package com.spring.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {

	public static Connection getConnection() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl",
					"scott",
					"tiger");
		}catch(SQLException e) {
			System.out.println("DB연동 오류");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 오류");
		}
		return null;
	}
	
	public static void close(PreparedStatement pstm, Connection conn) {
		
		if(pstm!=null) {
			try {
				if(!pstm.isClosed())
					pstm.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				pstm = null;
			}
		}
		if(conn!=null) {
			try {
				if(!conn.isClosed())
					conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				conn = null;
			}
		}
		
	}
	
	public static void close(ResultSet rs, PreparedStatement pstm, Connection conn) {
		if(pstm!=null) {
			try {
				if(!pstm.isClosed())
					pstm.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				pstm = null;
			}
		}
		if(conn!=null) {
			try {
				if(!conn.isClosed())
					conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				conn = null;
			}
		}
		if(rs!=null) {
			try {
				if(!rs.isClosed())
					rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				rs = null;
			}
		}
	}
}
