package com.spring.biz.board;


import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		
		//1. spring 컨테이너 구동
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. spring 컨테이너로부터 boardserviceImpl 객체 요청
		BoardService boardService = (BoardService) ctx.getBean("BoardService");
		
		//3. 글 등록
		/*BoardVO vo = new BoardVO();
		
		 * vo.setSeq(0); vo.setTitle("1"); vo.setWriter("1"); vo.setContent("1");
		 * boardService.InsertBoard(vo);
		 */
		BoardVO vo = new BoardVO();
		vo.setTitle("트랜젝션");
		vo.setWriter("lsm");
		vo.setContent("안녕하세요");
		boardService.InsertBoard(vo);
		List<BoardVO> list = boardService.SelectBoard();
		for(BoardVO lists : list) {
			System.out.println(lists.toString());
		}
		
		
		 
		
		 
		
		  
		 
		/*
		 * vo.setSeq(3); boardService.SelectOneBoard(vo);
		 */
		//4. 글 목록 검색
		/*
		 * boardService.SelectBoard(vo);
		 * 
		 * boardService.SelectOneBoard(vo);
		 */
		ctx.close();
	}
}
