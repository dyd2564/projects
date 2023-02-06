<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
	<h1>쿠키생성</h1>
	<a href="${contextPath}/sample08/getCookie">생성된 모든 쿠키 확인</a>
	<form action="${contextPath}/sample08/getCookieByName">
		<h1>이름으로 쿠키 확인</h1>
		<input type="text" name="name"><button>확인</button>
	</form>
</div>
<%@ include file="../layout/footer.jsp" %>


