<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
	<div class="jumbotron">
		<h2>첨부파일 여러개 업로드</h2>
	</div>
	
	<table class="table">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>첨부파일개수</td>
		</tr>
		<c:forEach items="${list}" var="b">
		<tr>
			<td>${b.bno}</td>
			<td>
				<a href="${contextPath}/board/detail?bno=${b.bno}">${b.title}</a>
			</td>
			<td>${b.writer}</td>
			<td>${b.attachFileCnt}</td>
		</tr>		
		</c:forEach>
	</table>
	<a href="${contextPath }/board/write" class="btn btn-primary">글쓰기</a>
	
	
</div>
<%@ include file="../layout/footer.jsp" %>

<script>
