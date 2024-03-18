<%@ page import="dao.BoardDao" %>
<%@ page import="dto.Board" %>
<%@page import="java.io.PrintWriter"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
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
	
}
int boardID = 0;
if(request.getParameter("boardID") != null){
	boardID = Integer.parseInt(request.getParameter("boardID"));
}if(boardID == 0){
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('유효하지 않은 글입니다')");
	script.println("location.href = 'board.jsp'");
	script.println("</script>");
}
Board board = new BoardDao().getBoard(boardID);
if(!memberID.equals(board.getMemberID())){
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('권한이 없습니다')");
	script.println("location.href = 'board.jsp'");
	script.println("</script>");
} 
  else{
	
		BoardDao boardDao = new BoardDao();
    	int result = boardDao.delete(boardID) ;
    	if(result == -1){
    		PrintWriter script = response.getWriter();
    		script.println("<script>");
    		script.println("alert('글삭제에 실패했습니다')");
    		script.println("history.back()");
    		script.println("</script>");
    	}
    	else{
    		
    		PrintWriter script = response.getWriter();
    		script.println("<script>");
    		script.println("location.href = 'board.jsp");
    		script.println("</script>");
    	}
	
}
%>

</body>
</html>