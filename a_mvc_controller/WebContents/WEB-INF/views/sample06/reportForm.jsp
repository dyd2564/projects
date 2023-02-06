<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
	<form action="${contextPath}/sample06/report" method="post">
		<div>
			이름 : <input type="text" name="name"><br>
			이메일 : <input type="text" name="email"><br>
		</div>
		<div>
			<h3>성적입력</h3>
			영어 : <input type="text" name="reportCard.eng"><br> 
			수학 : <input type="text" name="reportCard.math"><br>
			과학 : <input type="text" name="reportCard.science"><br>
		</div>
		<button>전송</button>
	</form>
</div>
<%@ include file="../layout/footer.jsp" %>


