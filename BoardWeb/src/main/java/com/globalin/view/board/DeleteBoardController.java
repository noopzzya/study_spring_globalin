package com.globalin.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.globalin.biz.board.BoardVO;
import com.globalin.biz.board.impl.BoardDAO;
import com.globalin.view.controller.Controller;

public class DeleteBoardController implements Controller {

	@Override
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("글 삭제 처리");
		
		// MVC1 deleteBoard_proc.jsp 소스 
		String seq = request.getParameter("seq");

		// db
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));

		BoardDAO boardDAO = new BoardDAO();
		boardDAO.deleteBoard(vo);

		// 응답화면
		return"getBoardList.do";

	}

}
