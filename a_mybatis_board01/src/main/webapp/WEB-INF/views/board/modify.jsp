<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
	<div class="jumbotron">
		<h1>게시물 수정</h1>
	</div>
	<form action="${contextPath}/board/modify" method="post">
	<div>
		<input type="hidden" name="bno" value="${board.bno}">
		번호 : ${board.bno}
	</div>
	<div>
		<input type="text" name="title" value="${board.title}">
	</div>
	<div>
		내용 :  
		<textarea rows="" cols="" name="content">${board.content}</textarea>
	</div>
	<div>
		작성자 : ${board.writer}
	</div>
	<div>
		작성일 : ${board.writeDate}
	</div>
	<div>
		<button type="submit">수정</button>
		<button type="button">취소</button>
	</div>
	</form>
</div>