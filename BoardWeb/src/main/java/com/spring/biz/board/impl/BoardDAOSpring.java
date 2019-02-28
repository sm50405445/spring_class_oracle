package com.spring.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.biz.board.BoardVO;

@Repository
public class BoardDAOSpring{
	
	@Autowired
	JdbcTemplate jdbctemplate;
	
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
	
		//글 동록
		public void InsertBoard(BoardVO vo) {
			System.out.println("==>spring JDBC로 insertBoard()");
			jdbctemplate.update(BOARD_INSERT,vo.getTitle(),vo.getWriter(),vo.getContent());
			
		}
		//글 수정
		public void UpdateBoard(BoardVO vo) {
			System.out.println("==>JDBC로 updateBoard() 기능처리");
			jdbctemplate.update(BOARD_UPDATE,vo.getContent(),vo.getTitle(),vo.getWriter(),vo.getSeq());
		}
		//글 삭제
		public void DeleteBoard(BoardVO vo) {
			System.out.println("==>JDBC로 deleteBoard() 기능처리");
			jdbctemplate.update(BOARD_DELETE,vo.getSeq());
		}
		//글 상세조회
		public BoardVO SelectOneBoard(BoardVO vo) {
			System.out.println("==>JDBC로 SelectOneBoard() 기능처리");
			
			Object[] args = {vo.getSeq()};
			return jdbctemplate.queryForObject(BOARD_GET, args,new BoardRowMapper());
		}
		//글 목록조회
		public List<BoardVO> SelectBoard() {
			System.out.println("==>JDBC로 SelectBoard() 기능처리");
			
			return jdbctemplate.query(BOARD_LIST, new BoardRowMapper());
		}
}
