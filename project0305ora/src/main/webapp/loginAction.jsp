<%@page import="java.io.PrintWriter"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");  //빌드패스다시한번
%>
<jsp:useBean id="member" class="dto.Member"  scope="page"/>
<jsp:setProperty name = "member" property = "memberID"/>
<jsp:setProperty name = "member" property = "memberPassword"/>    
<jsp:setProperty name = "member" property = "memberName"/>    
<jsp:setProperty name = "member" property = "memberGender"/>    
<jsp:setProperty name = "member" property = "memberEmail"/>    
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
		//script.println("alert('비밀번호가 틀립니다')");
		script.println("alert('로그인되어있습니다')");
		//script.println("history.back()");
		script.println("location.href = 'loginForm.jsp'");
		script.println("</script>");
		
	}
  		MemberDao memberDao = new MemberDao();
    	int result = memberDao.login(member.getMemberID(),member.getMemberPassword()) ;
    	if(result == 1){
    		session.setAttribute("memberID",member.getMemberID());
    		PrintWriter script = response.getWriter();
    		script.println("<script>");
    		script.println("location.href = 'loginForm.jsp");
    		script.println("</script>");
    	}else if(result == 0){
    		PrintWriter script = response.getWriter();
    		script.println("<script>");
    		//script.println("alert('비밀번호가 틀립니다')");
    		script.println("alert('로그인되어있습니다')");
    		//script.println("history.back()");
    		script.println("location.href = 'loginForm.jsp'");
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