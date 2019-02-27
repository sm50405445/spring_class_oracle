package com.spring.biz.board;

import java.util.ArrayList;

public interface BoardService {

	void InsertBoard(BoardVO vo);
	void UpdateBoard(BoardVO vo);
	void DeleteBoard(BoardVO vo);
	void SelectOneBoard(BoardVO vo);
	public ArrayList<BoardVO> SelectBoard(BoardVO vo);
	
}
