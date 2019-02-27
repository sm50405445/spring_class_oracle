package com.spring.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.spring.biz.board.BoardVO;
import com.spring.biz.common.JDBCUtil;

@Component
public class BoardDAO {

	//JDBC 관련 변수
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	
	//SQL 명령어들
	private final String BOARD_INSERT = "insert into board(seq,title,writer,content)"
			+ "values((select nvl(max(seq), 0)+1 from board),?,?,?)";
	
	private final String BOARD_UPDATE = "update board set title=?, writer=?, content=? where seq=?";
	
	private final String BOARD_GET = "select * from board where seq=?";
	
	private final String BOARD_DELETE = "delete board where seq=?";
	
	private final String BOARD_LIST = "select * from board order by seq desc";
	
	//crud 기능의 메서드 구현
	
	//글 동록
	public void InsertBoard(BoardVO vo) {
		System.out.println("==>JDBC로 insertBoard() 기능처리");
		
		try {			
			conn = JDBCUtil.getConnection();
			pstm = conn.prepareStatement(BOARD_INSERT);
			pstm.setString(1, vo.getTitle());
			pstm.setString(2, vo.getWriter());
			pstm.setString(3, vo.getContent());
			pstm.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstm, conn);
		}
	}
	//글 수정
	public void UpdateBoard(BoardVO vo) {
		System.out.println("==>JDBC로 updateBoard() 기능처리");
		
		try {
			conn = JDBCUtil.getConnection();
			pstm = conn.prepareStatement(BOARD_UPDATE);
			pstm.setString(1, vo.getTitle());
			pstm.setString(2, vo.getContent());
			pstm.setInt(3, vo.getSeq());
			pstm.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstm, conn);
		}
	}
	//글 삭제
	public void DeleteBoard(BoardVO vo) {
		System.out.println("==>JDBC로 deleteBoard() 기능처리");
		
		try {
			conn = JDBCUtil.getConnection();
			pstm = conn.prepareStatement(BOARD_DELETE);
			pstm.setInt(1, vo.getSeq());
			pstm.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstm, conn);
		}
	}
	//글 상세조회
	public void SelectOneBoard(BoardVO vo) {
		System.out.println("==>JDBC로 SelectOneBoard() 기능처리");
		
		try {
			conn = JDBCUtil.getConnection();
			pstm = conn.prepareStatement(BOARD_GET);
			pstm.setInt(1,vo.getSeq());
			rs=pstm.executeQuery();
			while(rs.next()) {
				vo.setSeq(rs.getInt("SEQ"));
				vo.setWriter(rs.getString("WRITER"));
				vo.setTitle(rs.getString("TITLE"));
				vo.setContent(rs.getString("CONTENT"));
				vo.setDate(rs.getDate("REGDATE"));
				vo.setCnt(rs.getInt("CNT"));
				System.out.println(vo.toString());
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstm, conn);
		}
	}
	//글 목록조회
	public ArrayList<BoardVO> SelectBoard(BoardVO vo) {
		System.out.println("==>JDBC로 SelectBoard() 기능처리");
		
		ArrayList<BoardVO> members = new ArrayList<BoardVO>();
		try {
			conn = JDBCUtil.getConnection();
			pstm = conn.prepareStatement(BOARD_LIST);
			pstm.executeQuery();
			rs = pstm.executeQuery();
			while(rs.next()) {
				vo.setSeq(rs.getInt("SEQ"));
				vo.setWriter(rs.getString("WRITER"));
				vo.setTitle(rs.getString("TITLE"));
				vo.setContent(rs.getString("CONTENT"));
				vo.setDate(rs.getDate("REGDATE"));
				vo.setCnt(rs.getInt("CNT"));
				members.add(vo);
			}
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstm, conn);
		}
		
		return members;
	}
	//
	
}
