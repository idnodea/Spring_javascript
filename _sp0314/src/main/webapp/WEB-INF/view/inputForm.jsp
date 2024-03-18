<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 파일명은 인풋폼, 요청명은 로그인폼, 화면 노출되는 건 요청명인 로그인폼 -->
	
	<h1>리절트를 실행하는 폼</h1><form action="result" method="get">
		<input type="text" name="id" />
		<input type="email" name="email" />
		<input type="submit" />
	</form>
	
	<!-- 아래의 폼액션 이름을 리절트2로 해보겠습니다. 컨트롤러에서 리절트2로 해도 리절트가 뜰거에요-->
	<h1>리절트2를 실행하는 폼</h1><form action="result2" method="get">
		<input type="text" name="id" />
		<input type="email" name="email" />
		<input type="submit" />
	</form>
</body>
</html>