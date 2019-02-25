package com.spring.biz.board;


public interface BoardService {

	void InsertBoard(BoardVO vo);
	void UpdateBoard(BoardVO vo);
	void DeleteBoard(BoardVO vo);
	void SelectOneBoard(BoardVO vo);
	void SelectBoard(BoardVO vo);
	
}
