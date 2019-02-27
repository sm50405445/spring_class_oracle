package com.spring.biz.board;


import java.util.ArrayList;

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
		vo.setSeq(0);
		vo.setTitle("1");
		vo.setWriter("1");
		vo.setContent("1");
		boardService.InsertBoard(vo);
		
		
		  ArrayList<BoardVO> members = boardService.SelectBoard(vo); for(int i
		  =0;i<members.size();i++) { System.out.println(members.get(i)); }
		 
		
		  
		 
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
