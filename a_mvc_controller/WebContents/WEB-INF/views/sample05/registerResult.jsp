<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>


<!-- 
커맨드 객체에 게터를 지정하지 않으면 PropertyNotFoundException 예외 발생 
 -->

<div class="container">
	이름 : ${memberDTO.userName }
	비밀번호 : ${memberDTO.userPassword } 
	이메일 : ${memberDTO.email }
</div>
<%@ include file="../layout/footer.jsp" %>


