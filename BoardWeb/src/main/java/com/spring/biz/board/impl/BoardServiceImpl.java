package com.spring.biz.board.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;



@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO dao;
	/* private LogAdvice log; */
	/* private Log4jAdvice log; */
	
	public BoardServiceImpl() {
		/* log = new Log4jAdvice(); */
	}
	
	@Override
	public void InsertBoard(BoardVO vo) {
		//log.printLogging();
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
	public ArrayList<BoardVO> SelectBoard(BoardVO vo) {
		//log.printLogging();
		return dao.SelectBoard(vo);
	}
	
	
	
}
