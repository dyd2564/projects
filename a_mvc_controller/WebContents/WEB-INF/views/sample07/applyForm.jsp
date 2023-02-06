<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
	<form action="${contextPath}/sample07/apply" method="post">
		<div>
			이름 : <input type="text" name="name"><br>
			이메일 : <input type="text" name="email"><br>
		</div>
		<div>
			<h4>1지망</h4>
			학교명 : <input type="text" name="universityList[0].name"><br> 
			전공 :  <input type="text" name="universityList[0].major"><br>
		</div>
		<div>
			<h4>2지망</h4>
			학교명 : <input type="text" name="universityList[1].name"><br> 
			전공 :  <input type="text" name="universityList[1].major"><br>
		</div>
		<div>
		<h4>3지망</h4>
			학교명 : <input type="text" name="universityList[2].name"><br> 
			전공 :  <input type="text" name="universityList[2].major"><br>
		</div>		
		<button>전송</button>
	</form>
</div>
<%@ include file="../layout/footer.jsp" %>


