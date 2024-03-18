<%@page import="java.io.PrintWriter"%>
<%@page import="bbs.BbsDao"%>
<%@page import="bbs.Bbs"%>
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
String userID=null;
if(session.getAttribute("userID") != null){
	userID = (String)session.getAttribute("userID");
}
if(userID != null){
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('로그인하세요')");
	script.println("location.href = 'login.jsp'");
	script.println("</script>");
	
}
int bbsID = 0;
if(request.getParameter("bbsID") != null){
	bbsID = Integer.parseInt(request.getParameter("bbsID"));
}if(bbsID == 0){
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('유효하지 않은 글입니다')");
	script.println("location.href = 'bbs.jsp'");
	script.println("</script>");
}
Bbs bbs = new BbsDao().getBbs(bbsID);
if(!userID.equals(bbs.getUserID())){
	PrintWriter script = response.getWriter();
	script.println("<script>");
	script.println("alert('권한이 없습니다')");
	script.println("location.href = 'bbs.jsp'");
	script.println("</script>");
} 
  else{
	
		BbsDao bbsDao = new BbsDao();
    	int result = bbsDao.delete(bbsID) ;
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
    		script.println("location.href = 'bbs.jsp");
    		script.println("</script>");
    	}
	
}


		
  		
  %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>