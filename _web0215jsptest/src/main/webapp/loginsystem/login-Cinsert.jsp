<%@page import="dao.MemberDao"%>
<%@page import="dto.Board"%>
<%@page import="dao.BoardDao2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>  
<%@ page import="java.time.*" %>
 
<%
 request.setCharacterEncoding("utf-8");

     // 양식에 입력되었던 값 읽기
     String num  = request.getParameter("num" );
     String title   = request.getParameter("title"  );
     String content = request.getParameter("content");
     String name = request.getParameter("name");

     // 빈 칸이 하나라도 있으면 오류 출력하고 종료
     if (
         title   == null || title.length()   == 0 ||
         content == null || content.length() == 0 ||
         name   == null || title.length()   == 0 ) {
 %>      
        <script>
            alert('모든 항목이 빈칸 없이 입력되어야 합니다.');
            history.back();
        </script>
<%
return;
    }

    String memberId = (String) session.getAttribute("MEMBERID");
    if (memberId == null) {
    	response.sendRedirect("login-CloginForm.jsp");
    }
    BoardDao boardDao = BoardDao.getInstance();
    Board board = new Board(title,content,name);
    MemberDao memberDao = MemberDao.getInstance();
    
    
    
    //Board board = new Board(0, writer, title, content, "", 0);
    /*Board board = new Board();
    board.setWriter(writer);
    board.setTitle(title);
    board.setContent(content);*/
    boardDao.insert(board);
    //memberDao.insert(board);
    // 목록보기 화면으로 돌아감
    response.sendRedirect("login-Clist.jsp");
%>     