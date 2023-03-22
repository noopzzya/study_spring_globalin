package com.globalin.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.globalin.biz.board.impl.BoardDAO;

public class BoardServiceClient {

	public static void main(String[] args) {
		
		
	    // 1. Spring 컨테이너 구동
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml"); 
		
		
		//2. Spring 컨테이너로 부터 BoardServiceImpl 객체 Lookup 한다.
		BoardService boardService = (BoardService)container.getBean("boardService");
		
		/*
		//3 글 등록 기능 테스트
		BoardVO vo = new BoardVO();
		//vo.setSeq(100);
		vo.setTitle("임시 제목");
		vo.setWriter("홍길동");
		vo.setContent("Spring Mybatis 내용........................");
		boardService.insertBoard(vo);
		
		//4. 글 목록 검색 기능 테스트
		List<BoardVO> boardList = boardService.getBoardList(vo);
		
		for(BoardVO board : boardList) {
			System.out.println("-----> "+board.toString());
		}
		
		//5. Spring 컨테이너 종료
		container.close();
		*/
		

		
		//BoardDAO boardDAO = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		vo.setTitle("myBatis 제목");
		vo.setWriter("홍길동");
		vo.setContent("Spring MyBatis 테스트입니다.");
		boardService.insertBoard(vo);
		
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
			
		for(BoardVO board : boardList) {
			System.out.println("-----> "+board.toString());
		}
	
		container.close();
		
	}

}
