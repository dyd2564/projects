<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
	<h1>전송결과</h1>
	<!-- @ModelAttribute를 지정하지 않았을 때  -->
	${sampleVO.id}<br>
	${sampleVO.title}<br>
	${sampleVO.content}<br>
	
	<!-- @ModelAttribute("svo")로 지정했을 때 -->
	${svo.id}<br>
	${svo.title}<br>
	${svo.content}<br>
</div>
<%@ include file="../layout/footer.jsp" %>


