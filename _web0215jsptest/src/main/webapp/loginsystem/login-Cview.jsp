<%@page import="dto.Member"%>
<%@page import="dao.MemberDao"%>
<%@page import="dto.Board"%>
<%@page import="dao.BoardDao2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>

<%
// num 파라미터를 정수로 파싱하는 부분
    int num = 0; // 기본값 설정
    String numParam = request.getParameter("num");
    if (numParam != null && !numParam.isEmpty()) {
        num = Integer.parseInt(numParam);
    }
    
    // 게시글 데이터를 담을 변수 정의
    String name  = "";
    String title   = "";
    String content = "";
    String regtime = "";
    
    int    hits    = 0;
    
    String id = "";
    String email = "";
    
    // 세션에서 회원 아이디를 가져옵니다.
    String memberId = (String)session.getAttribute("MEMBERID");
    if (memberId == null) {
        response.sendRedirect("login-CloginForm.jsp");
    }
    
    // 회원 정보를 가져옵니다.
    MemberDao memberDao = MemberDao.getInstance();
    Member member = memberDao.select(memberId);
    
    // 글 데이터를 가져옵니다.
    BoardDao boarddao = BoardDao.getInstance();
    Board board = boarddao.selectOne(num, true);
    
    // 글 데이터를 변수에 저장
    if (board != null) {
        name  = board.getName();
        title   = board.getTitle();
        content = board.getContent();
        regtime = board.getRegtime();
        hits    = board.getHits();
    }
    
    // 회원 아이디를 변수에 저장
    //String id= member.getId();
    
    // 글 제목과 내용이 웹 페이지에 올바르게 출력되도록 
    // 공백과 줄 바꿈 처리
    title   = title.replace  (" ", "&nbsp;");
    content = content.replace(" ", "&nbsp;").replace("\n", "<br>");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        table { width:680px; text-align:center; }
        th    { width:100px; background-color:cyan; }
        td    { text-align:left; border:1px solid gray; }
    </style>
</head>
<body>

<table>
    <tr>
        <th>제목</th>
        <td><%=title%></td>
    </tr>
    <tr>
        <th>작성자</th>
        <td><%=name%></td>
    </tr>
    <tr>
        <th>작성일시</th>
        <td><%=regtime%></td>
    </tr>
    <tr>
        <th>조회수</th>
        <td><%=hits%></td>
    </tr>
    <tr>
        <th>내용</th>
        <td><%=content%></td>
    </tr>
</table>

<br>
<input type="button" value="목록보기" onclick="location.href='login-Clist.jsp'">
<input type="button" value="수정"
       onclick="location.href='login-Cwrite.jsp?num=<%=num%>'">
<input type="button" value="삭제"
       onclick="location.href='login-Cdelete.jsp?num=<%=num%>'">

</body>
</html>