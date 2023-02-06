<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
<title>Insert title here</title>
</head>
<body>
Hello

<form action="${pageContext.request.contextPath}/result" method="post">
	<input type="text" name="userName">
	<button>전송</button>
</form>
</body>
</html>