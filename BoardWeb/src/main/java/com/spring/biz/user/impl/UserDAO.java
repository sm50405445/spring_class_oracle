package com.spring.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.spring.biz.common.JDBCUtil;
import com.spring.biz.user.UserVO;

@Component
public class UserDAO {

	//JDBC 변수 선언
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	
	//SQL 명령어
	private final String USER_INSERT = "insert into Users(id,password,name,role) values(?,?,?,?)";
	private final String USER_GET = "select * from users where id=?";
	
	//crud 관련 메서드 선언
	
	//등록
	public UserVO getUser(UserVO vo) {
		UserVO user = new UserVO();
		conn = JDBCUtil.getConnection();
		try {
			pstm = conn.prepareStatement(USER_GET);
			pstm.setString(1, vo.getId());
			pstm.setString(2, vo.getPassword());
			rs = pstm.executeQuery();
			if(rs.next()) {
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstm, conn);
		}
		
		
		return user;
		
	}
}
