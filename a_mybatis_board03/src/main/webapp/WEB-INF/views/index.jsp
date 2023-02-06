<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>

<div class="container">
	<h1>메인 </h1>
	<div>
		<c:if test="${not empty result}">
			<b>${result}</b>
		</c:if>
	</div>
</div>
<%@ include file="layout/footer.jsp" %>


