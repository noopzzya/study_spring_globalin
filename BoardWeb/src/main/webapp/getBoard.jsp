<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="com.globalin.biz.board.impl.BoardDAO"%>
<%@page import="com.globalin.biz.board.BoardVO"%>

<%
// 검색할 글번호 추출 (MVC2 수정하면서 주석처리)
//String seq = request.getParameter("seq");

// DB 연동
//BoardVO vo = new BoardVO();
//vo.setSeq(Integer.parseInt(seq));
//BoardDAO boardDAO = new BoardDAO();
//BoardVO board = boardDAO.getBoard(vo);
BoardVO board = (BoardVO)session.getAttribute("board");

// 응답화면 구성
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세 보기</title>
</head>
<body>

	<div align="center">
		<h1>글 상세 보기</h1>
		<a href="logout.do">Log-out</a>
		<hr>

		<form action="updateBoard.do" method="post">
			<input type="hidden" name="seq" value="<%=board.getSeq()%>">

			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<td bgcolor="orange" width="70">제목</td>
					<td align="left"><input type="text" name="title"
						value="<%=board.getTitle()%>"></td>
				</tr>

				<tr>
					<td bgcolor="orange" width="70">작성자</td>
					<td align="left"><%=board.getWriter()%></td>
				</tr>

				<tr>
					<td bgcolor="orange" width="70">내용</td>
					<td align="left">
						<textarea name="content" cols="40" rows="10"><%=board.getContent()%></textarea>
					</td>
				</tr>

				<tr>
					<td bgcolor="orange">등록일</td>
					<td align="left"><input type="text" name="regdate" value="<%=board.getRegDate()%>"></td>
				</tr>

				<tr>
					<td bgcolor="orange" width="70">조회수</td>
					<td align="left"><input type="text" name="cnt" value="<%=board.getCnt()%>"></td>
				</tr>


				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="글수정">
					</td>
				</tr>
			</table>
		</form>

		<hr>
		<a href="insertBoard.jsp">글등록</a>&nbsp;&nbsp;&nbsp; 
		<a href="deleteBoard.do?seq=<%=board.getSeq()%>">글삭제</a>&nbsp;&nbsp;&nbsp;
		<a href="getBoardList.do">글목록</a>
	</div>

</body>
</html>