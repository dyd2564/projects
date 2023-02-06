<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
	<form action="${contextPath}/sample05/register" method="post">
		이름 : <input type="text" name="userName">
		비밀번호 : <input type="password" name="userPassword">
		이메일 : <input type="text" name="email">
		<button>전송</button>
	</form>
</div>
<%@ include file="../layout/footer.jsp" %>


