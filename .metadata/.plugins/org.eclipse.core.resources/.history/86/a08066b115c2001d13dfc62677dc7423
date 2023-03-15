<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="com.globalin.biz.board.BoardVO"%>
<%@page import="com.globalin.biz.board.impl.BoardDAO"%>

<%
request.setCharacterEncoding("utf-8");

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

// 응답화면
response.sendRedirect("getBoardList.jsp");

%>    
