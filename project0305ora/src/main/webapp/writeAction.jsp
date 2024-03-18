<%@page import="java.io.PrintWriter"%>
<%@page import="dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="board" class="dto.Board"  scope="page"/>
<jsp:setProperty name = "board" property = "boardTitle"/>
<jsp:setProperty name = "board" property = "boardContent"/>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String memberID=null;
if(session.getAttribute("memberID") != null){
	memberID = (String)session.getAttribute("memberID");
}
if(memberID != null){
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('로그인하세요')");
	script.println("location.href = 'login.jsp'");
	script.println("</script>");
	
}else{
	if(board.getBoardTitle() == null || board.getBoardContent() == null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('입력이 안 된 사항이 있습니다')");
		script.println("history.back()");
		script.println("</script>");
	}else{
		BoardDao boardDao = new BoardDao();
    	int result = boardDao.write(board.getBoardTitle(), memberID, board.getBoardContent()) ;
    	if(result == -1){
    		PrintWriter script = response.getWriter();
    		script.println("<script>");
    		script.println("alert('글쓰기에 실패했습니다')");
    		script.println("history.back()");
    		script.println("</script>");
    	}else{
    		
    		PrintWriter script = response.getWriter();
    		script.println("<script>");
    		script.println("location.href = 'board.jsp");
    		script.println("</script>");
    	}
	}
}
%>

</body>
</html>