package com.globalin.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.globalin.biz.board.BoardVO;
import com.globalin.biz.board.impl.BoardDAO;
import com.globalin.view.controller.Controller;

public class GetBoardController implements Controller {
	
	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) {
	
		System.out.println("글 상세 조회 처리");
		
		// 검색할 글번호 추출 (MVC1 getBoard.jsp 소스)
		String seq = request.getParameter("seq");
	
		// DB 연동
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = boardDAO.getBoard(vo);
		
		// 응답화면 구성
		HttpSession session = request.getSession();
		session.setAttribute("board", board);
		
		return "getBoard";
	}
}
