package com.globalin.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.globalin.biz.board.BoardVO;
import com.globalin.biz.board.impl.BoardDAO;

public class InsertBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 등록 처리");

		// MVC1 insertBoard_proc.jsp 소스
		// request.setCharacterEncoding("utf-8");

		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		// db
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);

		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(vo);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoardList.do");
		
		// 응답화면
		return mav;
	}

}
