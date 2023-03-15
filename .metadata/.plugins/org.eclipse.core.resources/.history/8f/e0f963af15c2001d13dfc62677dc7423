<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="com.globalin.biz.board.BoardVO"%>
<%@page import="com.globalin.biz.board.impl.BoardDAO"%>

<%

String seq = request.getParameter("seq");

// db
BoardVO vo = new BoardVO();
vo.setSeq(Integer.parseInt(seq));

BoardDAO boardDAO = new BoardDAO();
boardDAO.deleteBoard(vo);

// 응답화면
response.sendRedirect("getBoardList.jsp");

%>