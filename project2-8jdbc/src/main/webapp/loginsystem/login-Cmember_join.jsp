<%@ page import="dto.Member" %>
<%@ page import="dao.MemberDao" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Join</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    String id = request.getParameter("id");
    String email = request.getParameter("email");
    String name = request.getParameter("name");
    Member member = MemberDao.getInstance().selectForLogin(id, email);
    if (member != null) {
        // 이미 있는 아이디이면 오류 표시
%>
    <script>
        alert("이미 가입된 아이디입니다.");
        history.back();
    </script>
<%
    } else {
        Member member1 = new Member(id, email, name);
        MemberDao.getInstance().insert(member1);
%>
    <script>
        alert("가입이 완료되었습니다.");
        location.href = "login.jsp";
    </script>
<%
    }
%>
</body>
</html>