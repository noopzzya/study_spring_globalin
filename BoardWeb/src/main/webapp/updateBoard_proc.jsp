<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="com.globalin.biz.board.BoardVO"%>
<%@page import="com.globalin.biz.board.impl.BoardDAO"%>

<%
request.setCharacterEncoding("utf-8");

String title = request.getParameter("title");
String content = request.getParameter("content");
String seq = request.getParameter("seq");

// db
BoardVO vo = new BoardVO();
vo.setTitle(title);
vo.setContent(content);
vo.setSeq(Integer.parseInt(seq));

BoardDAO boardDAO = new BoardDAO();
boardDAO.updateBoard(vo);

// 응답화면
response.sendRedirect("getBoardList.jsp");

%>