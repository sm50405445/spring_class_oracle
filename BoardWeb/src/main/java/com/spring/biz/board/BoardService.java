package com.spring.biz.board;

import java.util.List;

public interface BoardService {

	void InsertBoard(BoardVO vo);
	void UpdateBoard(BoardVO vo);
	void DeleteBoard(BoardVO vo);
	void SelectOneBoard(BoardVO vo);
	public List<BoardVO> SelectBoard();
	
}
