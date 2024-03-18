<%@page import="java.io.PrintWriter"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
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


		if(member.getMemberID() == null || member.getMemberPassword() == null || member.getMemberName() == null
				|| member.getMemberGender() == null || member.getMemberEmail() == null){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('입력이 안 된 사항이 있습니다')");
    		script.println("history.back()");
    		script.println("</script>");
		}else{
			MemberDao memberDao = new MemberDao();
	    	int result = memberDao.join(member) ;
	    	if(result == -1){
	    		PrintWriter script = response.getWriter();
	    		script.println("<script>");
	    		script.println("alert('이미 존재하는 아이디입니다')");
	    		script.println("history.back()");
	    		script.println("</script>");
	    	//}else if(result == 0){
	    	}else{
	    		session.setAttribute("memberID",member.getMemberID());
	    		PrintWriter script = response.getWriter();
	    		script.println("<script>");
	    		script.println("location.href = 'loginForm.jsp");
	    		script.println("</script>");
	    	}
		}
  		
  %>

</body>
</html>