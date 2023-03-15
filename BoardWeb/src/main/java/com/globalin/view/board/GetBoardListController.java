package com.globalin.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.globalin.biz.board.BoardVO;
import com.globalin.biz.board.impl.BoardDAO;

public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("글 목록 검색 처리");

		// 데이터베이스 연동 (MVC1 getBoardList.jsp 소스)
		//BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList();

		/*
		// 검색 결과를 세션에 저장하고 목록 화면을 리턴
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);
		return "getBoardList";
		*/
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList);
		mav.setViewName("getBoardList");
		return mav;
	}

}
