<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.MemberDao" %>
<%@ page import = "java.io.PrintWriter" %>
<%
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="member" class="dto.Member"  scope="page"></jsp:useBean>
<jsp:setProperty name = "member" property = "id"/>
<jsp:setProperty name = "member" property = "password"/>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!doctype html>
<html lang="en" data-bs-theme="auto">
  <head><script src="assets/js/color-modes.js"></script>
<!--../ 상대주소   /절대주소-->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.115.4">
    <title>멤버,보드연동프로젝트</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/sign-in/">
	<link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-default">
		<div class ="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle ="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				
			
			</button>
			<a class="navbar-brand" href="main.jsp">멤버,보드연동프로젝트</a>
		</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="main.jsp">메인</a></li>
				<li><a href="bbs.jsp">게시판</a></li>
			
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
				<a href="#" class ="dropdown-toggle" data-toggle="dropdown" 
					role="button" aria-haspopup="true" aria-expanded="false">
					접속하기
						<span class="caret"></span>
				</a>
				<ul class="dropdown-menu">
					<li class="active"><a href="login.jsp">로그인</a>
					<li><a href="join.jsp">회원가입</a>
				</ul>
			
		</div>
	</nav>
	<div class="container">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<div class="jumbotron" style="padding-top:20px;">
				<form method="post" action="loginAction.jsp">
					<h3 style="text-align:center;">로그인 화면</h3>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="아이디" name="userID" maxlength="20"/>
					</div>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="qlalfqjsgh" name="userPassword" maxlength="20"/>
					</div>
					<input type="submit" class="btn btn-primary form-control" value="로그인">
				</form>
			</div>
		</div>
		<div class="col-lg-4"></div>
	</div>
<script src="assets/js/bootstrap.bundle.min.js"></script>	
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</body>
  <%
  MemberDao memberDao = new MemberDao();
      	int result = memberDao.login(member.getId(),member.getPassword()) ;
      	if(result == 1){
      		PrintWriter script = response.getWriter();
      		script.println("<script>");
      		script.println("location.href = 'main.jsp");
      		script.println("</script>");
      	}else if(result == 0){
      		PrintWriter script = response.getWriter();
      		script.println("<script>");
      		script.println("alert('비밀번호가 틀립니다')");
      		script.println("history.back()");
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

</html>
