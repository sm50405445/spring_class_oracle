package com.spring.biz.board.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO dao;

	@Override
	public void InsertBoard(BoardVO vo) {
		dao.InsertBoard(vo);
	}

	@Override
	public void UpdateBoard(BoardVO vo) {
		dao.UpdateBoard(vo);
	}

	@Override
	public void DeleteBoard(BoardVO vo) {
		dao.DeleteBoard(vo);
	}

	@Override
	public void SelectOneBoard(BoardVO vo) {
		dao.SelectOneBoard(vo);
	}

	@Override
	public void SelectBoard(BoardVO vo) {
		dao.SelectBoard(vo);
	}
	
	
	
}
