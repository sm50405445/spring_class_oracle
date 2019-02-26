package com.spring.biz.board;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.biz.board.impl.BoardServiceImpl;

public class BoardServiceClient {

	public static void main(String[] args) {
		
		//1. spring 컨테이너 구동
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. spring 컨테이너로부터 boardserviceImpl 객체 요청
		BoardService boardService = (BoardService) ctx.getBean("BoardService");
		
		//3. 글 등록
		BoardVO vo = new BoardVO();
		/*
		 * vo.setTitle("하이"); vo.setWriter("홍길동"); vo.setContent("하이");
		 * boardService.InsertBoard(vo);
		 */
		boardService.SelectBoard(vo);
		vo.setSeq(1);
		boardService.SelectOneBoard(vo);
		//4. 글 목록 검색
		/*
		 * boardService.SelectBoard(vo);
		 * 
		 * boardService.SelectOneBoard(vo);
		 */
		ctx.close();
	}
}
