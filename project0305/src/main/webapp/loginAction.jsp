<%@page import="java.io.PrintWriter"%>
<%@page import="user.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");  //빌드패스다시한번
%>
<jsp:useBean id="user" class="user.User"  scope="page"/>
<jsp:setProperty name = "user" property = "userID"/>
<jsp:setProperty name = "user" property = "userPassword"/>    
<jsp:setProperty name = "user" property = "userName"/>    
<jsp:setProperty name = "user" property = "userGender"/>    
<jsp:setProperty name = "user" property = "userEmail"/>    
    
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
		//script.println("alert('비밀번호가 틀립니다')");
		script.println("alert('로그인되어있습니다')");
		//script.println("history.back()");
		script.println("location.href = 'main.jsp'");
		script.println("</script>");
		
	}
  		UserDao userDao = new UserDao();
    	int result = userDao.login(user.getUserID(),user.getUserPassword()) ;
    	if(result == 1){
    		session.setAttribute("userID",user.getUserID());
    		PrintWriter script = response.getWriter();
    		script.println("<script>");
    		script.println("location.href = 'main.jsp");
    		script.println("</script>");
    	}else if(result == 0){
    		PrintWriter script = response.getWriter();
    		script.println("<script>");
    		//script.println("alert('비밀번호가 틀립니다')");
    		script.println("alert('로그인되어있습니다')");
    		//script.println("history.back()");
    		script.println("location.href = 'main.jsp'");
    		script.println("</script>");
    	}else if(result == -1){
    		PrintWriter script = response.getWriter();
    		script.println("<script>");
    		script.println("alert('존재하지않습니다');");
    		script.println("history.back()");
    		script.println("</script>");
    	}else if(result == -2){
    		PrintWriter script = response.getWriter();
    		script.println("<script>");
    		script.println("alert('데이터베이스오류')");
    		script.println("history.back();");
    		script.println("</script>");
    	}
  %>
</body>
</html>