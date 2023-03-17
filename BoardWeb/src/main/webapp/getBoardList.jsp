<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
</head>
<body>
	<div align="center">
		<h1> <spring:message code="message.board.list.mainTitle"/> </h1>
		<h3>
			${userName}<spring:message code="message.board.list.welcomMsg"/>
			<a href="logout.do">Log-out</a>
		</h3>

		<!-- 검색 시작 -->
		<form action="getBoardList.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0" width="700">
				<tr>
					<td align="right">
						<select name="searchCondition">
								<c:forEach var="option" items="${conditionMap}">
									<option value="${option.value}">${option.key}</option>
								</c:forEach>
						</select>
						<input name="searchKeyword" type="text"> 
						<input type="submit" value="<spring:message code="message.board.list.search.btn"/>">
					</td>
				</tr>
			</table>
		</form>

		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr align="center">
				<th bgcolor="orange" width="100"><spring:message code="message.board.list.search.seq"/></th>
				<th bgcolor="orange" width="200"><spring:message code="message.board.list.search.title"/></th>
				<th bgcolor="orange" width="150"><spring:message code="message.board.list.search.writer"/></th>
				<th bgcolor="orange" width="150"><spring:message code="message.board.list.search.regDate"/></th>
				<th bgcolor="orange" width="100"><spring:message code="message.board.list.search.cnt"/></th>
			</tr>

			<c:forEach var="board" items="${boardList}">
				<tr align="center">
					<td>${board.seq }</td>
					<td><a href="getBoard.do?seq=${board.seq}">${board.title}</a></td>

					<td>${board.writer}</td>
					<td>${board.regDate}</td>
					<td>${board.cnt}</td>

				</tr>

			</c:forEach>
		</table>
		<br> <a href="insertBoard.jsp"><spring:message code="message.board.list.link.insertBoard"/></a>
	</div>


</body>
</html>




