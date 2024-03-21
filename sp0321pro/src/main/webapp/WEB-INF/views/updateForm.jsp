<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE HTML>
<head>
	<title>top page</title>
	<meta http-equiv="Content-Type" 
		content="text/html; charset=UTF-8" />
	<style>
	h1 { font-size:18pt; font-weight:bold; color:gray; }
	body { font-size:13pt; color:gray; margin:5px 25px; }
	tr { margin:5px; }
	th { padding:5px; color:white; background:darkgray; }
	td { padding:5px; color:black; background:#e0e0ff; }
	.err { color:red; }
	</style>
</head>
<body>
	<h1>Hello page</h1><a href="index">홈으로</a>
	<p></p>
	<table>
	<form method="post" action="update">
	<tr><td><label for="membernoInput">회원번호</label></td>
        <td><input type="hidden" id="membernoInput"  name="memberno" value="${member.memberno}"></td></tr>
		<tr><td><label for="name">이름</label></td>
			<td><input type="text" name="name" value="${member.name}"/></td></tr>
		<tr><td><label for="age">연령</label></td>
			<td><input type="number" name="age" value="${member.age}"/></td></tr>
		<tr><td><label for="email">메일</label></td>
			<td><input type="text" name="email" value="${member.email}" /></td></tr>
		<tr><td><label for="memo">메모</label></td>
			<td><textarea name="memo" cols="20" rows="5" value="${member.memo}"></textarea></td></tr>
		<tr><td></td><td><input type="submit" /></td></tr>
</form>
	</table>
	<hr/>
	<table>
	<tr>
		<th>회원번호</th><th>ID</th><th>이름</th><th>연령</th><th>이메일</th><th>메모</th><th>기능</th>
	</tr>
	<c:forEach var="member" items="${list}">
	<tr>
		<td>${member.memberno}</td>
		<td><a href="update?id=${member.id}">${member.id}</a></td>
		<td>${member.name}</td>
		<td>${member.age}</td>
		<td>${member.email}</td>
		<td><textarea name="memo">${member.memo}</textarea></td>
		<td>삭제는 삭제페이지에서</td>
	</tr>
	</c:forEach>
	</table>
	
</body>
</html>
