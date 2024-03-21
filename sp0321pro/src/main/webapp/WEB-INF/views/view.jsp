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
	<form method="post" action="input">
	<tr><td><label for="membernoInput">회원번호</label></td>
        <td><input type="hidden" id="membernoInput"  name="memberno" value="${member.memberno}"></td></tr>
    <tr><td><label for="membernoInput">아이디</label></td>
        <td><input type="text" id="membernoInput"  name="id" ></td></tr>
    <tr><td><label for="nameInput">이름</label></td>
        <td><input type="text" id="nameInput" name="name" /></td></tr>
    <tr><td><label for="ageInput">연령</label></td>
        <td><input type="text" id="ageInput" name="age" /></td></tr>
    <tr><td><label for="mailInput">메일</label></td>
        <td><input type="text" id="mailInput" name="email" /></td></tr>
    <tr><td><label for="memoInput">메모</label></td>
        <td><textarea id="memoInput" name="memo" cols="20" rows="5"></textarea></td></tr>
    <tr><td></td><td><input type="submit" /></td></tr>
</form>
	</table>
	<hr/>
	<table>
	<tr>
		<th>회원번호</th><th>ID(수정)</th><th>이름</th><th>연령</th><th>이메일</th><th>메모</th><th>회원탈퇴</th><th>메모관련</th>
	</tr>
	<c:forEach var="member" items="${list}">
	<tr>
		<td>${member.memberno}</td>
		<td><a href="update?id=${member.id}">${member.id}</a></td>
		<td>${member.name}</td>
		<td>${member.age}</td>
		<td>${member.email}</td>
		<td>${member.memo}</td>
		<td><a href="javascript:void(0);" onclick="confirmDelete('${member.id}')">${member.id}삭제</a></td>
		<td>
        <form action="updateMemo" method="post">
            <input type="hidden" name="id" value="${member.id}" />
            <input type="text" name="memo" value="${member.memo}" />
            <input type="submit" value="저장" />
             <button type="button" onclick="confirmDelete(this.form)">삭제</button>
        </form>
   		</td>
    	
       		
  		
		</tr>
	</c:forEach>
	</table>
	<script>
    function confirmDelete(id) {
        if (confirm("정말로 삭제하시겠습니까?")) {
            window.location.href = "delete?id=" + id;
        }
    }
	</script>
</body>
</html>
