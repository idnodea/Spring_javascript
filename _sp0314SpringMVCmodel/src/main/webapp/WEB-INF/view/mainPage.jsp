<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인성공</h1><br/>
	${MemberDto.id} 님 환영합니다<br/>
	${MemberDto.email} <br/>
	${str}
	
	<a href="">홈화면으로</a>
	<a href="${pageContext.request.contextPath}/">홈으로</a>
	
	
</body>
</html>