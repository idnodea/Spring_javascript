<%@page import="dao.MemberDao"%>
<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>   

<%
	String id = request.getParameter("id");
	String email = request.getParameter("pw");
	Member memberDao = MemberDao.getInstance().selectForLogin(id, email);
    
    // 그런 레코드가 있으면, 세션 속성을 등록하고, 메인 화면으로 돌아감
    if (memberDao != null) {
        //session.setAttribute("userId",   member.getId());
        //session.setAttribute("userName", member.getName());
        session.setAttribute("member", memberDao);
        
        
        response.sendRedirect("login_main.jsp");   
        return;
    }
        

%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>

<script>
    alert('아이디 또는 비밀번호가 틀립니다!');
    history.back();
</script>
 
</body>
</html>