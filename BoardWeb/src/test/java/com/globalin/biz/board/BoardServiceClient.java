package com.globalin.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {

	public static void main(String[] args) {
		AbstractApplicationContext container=new GenericXmlApplicationContext("applicationContext.xml");
		
		BoardService boardService=(BoardService)container.getBean("boardService");
		
		//글 등록
		BoardVO vo=new BoardVO();
//		vo.setSeq(100);
		vo.setTitle("임시 제목");
		vo.setWriter("홍길동");
		vo.setContent("Spring Mybatis 내용");
		//vo.setSeq(0); // 추가
//		boardService.insertBoard(vo);
		
		
		boardService.insertBoard(vo);
		
//		// 4. 글 목록 검색
		List<BoardVO> boardList=boardService.getBoardList(vo);
		
		for (BoardVO boardVO : boardList) {
			System.out.println(boardVO.toString());
		}
		
		// 5. Spring 컨테이너 종료
		container.close();
		
	}
}
