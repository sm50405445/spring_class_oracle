package com.spring.biz.board.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;



@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAOSpring dao;
	/* private LogAdvice log; */
	/* private Log4jAdvice log; */
	
	public BoardServiceImpl() {
		/* log = new Log4jAdvice(); */
	}
	
	@Override
	public void InsertBoard(BoardVO vo) {
		/* log.printLogging(); */
		
		 if(vo.getSeq()==0) { 
			 new IllegalArgumentException("0번글은 등록못합니다"); 
		 }
		dao.InsertBoard(vo);
	}

	@Override
	public void UpdateBoard(BoardVO vo) {
		//log.printLogging();
		dao.UpdateBoard(vo);
	}

	@Override
	public void DeleteBoard(BoardVO vo) {
		//log.printLogging();
		dao.DeleteBoard(vo);
	}

	@Override
	public void SelectOneBoard(BoardVO vo) {
		//log.printLogging();
		dao.SelectOneBoard(vo);
	}

	@Override
	public List<BoardVO> SelectBoard() {
		//log.printLogging();
		List<BoardVO> members = dao.SelectBoard();
		return members;
	}
	
	
	
}
