<%@page import="dao.MemberDao"%>
<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<%
    request.setCharacterEncoding("utf-8");

    // 수정된 회원 정보를 가져옵니다.
    String id = request.getParameter("id");
    String email = request.getParameter("email");
    String name = request.getParameter("name");
    
    // 기존 회원 정보를 가져와서 업데이트합니다.
    MemberDao memberDao = MemberDao.getInstance();
    Member member = memberDao.selectMember(Integer.parseInt(id)); // 기존 회원 정보를 가져옵니다.
    if (member != null) {
        member.setEmail(email);
        member.setName(name);
        
        // 회원 정보 업데이트
        memberDao.update(member);
        
        // 세션에 업데이트된 회원 정보 저장
        session.setAttribute("member", member);
    } else {
        // 기존 회원 정보가 없는 경우 처리
        // 예를 들어, 해당 아이디에 해당하는 회원이 없는 경우 등
        // 이 부분은 프로젝트의 요구사항에 따라서 처리해야 합니다.
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>

<script>
    alert('수정이 완료되었습니다.');
    // 부모 창 새로고침이 필요한 경우에만 아래 코드를 사용합니다.
    // opener.location.reload(true);  
    window.close(); // 현재 창 닫기
</script>

</body>
</html>