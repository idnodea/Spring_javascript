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
	
	
	</table>
	<hr/>
	<table>
	<tr>
		<th>회원번호</th><th>ID(수정)</th><th>이름</th><th>연령</th><th>이메일</th><th>메모</th><th>회원탈퇴</th><th>메모관련</th>
	</tr>
	<c:forEach var="member" items="${list}">
	<tr>
		<td>${member.memberno}</td>
		<td><a href="updateForm?memberno=${member.memberno}">${member.id}</a></td>
		<td>${member.name}</td>
		<td>${member.age}</td>
		<td>${member.email}</td>
		<td>${member.memo}</td>
		<td><a href="javascript:void(0);" onclick="confirmDelete('${member.memberno}')">${member.id}삭제</a></td>
		<td>
       		  <form action="memoUpdate" method="get">
        			<input type="hidden" name="memberno" value="${member.memberno}" />
       				<input type="text" name="memo" value="${member.memo}" /><br>
        			<input type="submit" value="메모 수정" />
   			 </form>
  		  <!-- 메모 삭제 버튼 -->
    		<button onclick="location.href='memoDelete?memberno=${member.memberno}'">메모 삭제
   		</td>
    	
       		
  		
		</tr>
	</c:forEach>
	</table>
	<script>
    function confirmDelete(id) {
        if (confirm("정말로 삭제하시겠습니까?")) {
            window.location.href = "delete?memberno=" + id;
        }
    }
	</script>
</body>
</html>
