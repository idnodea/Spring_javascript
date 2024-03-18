<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>

<%

    //if ((String)session.getAttribute("userId") != null) {
    Member member = (Member)session.getAttribute("member");
    
        // 로그인 상태일 때의 출력 
%>
        <form action="logout.jsp" method="post">  
            <%=member.getName()%>님 로그인
            <input type="submit" value="로그아웃">
            <input type="button" value="회원정보 수정" 
                   onclick="window.open('member_update_form.jsp', 'popup', 
                                        'width=400, height=200')">
        </form>
<%  
    
%>
</body>
</html>