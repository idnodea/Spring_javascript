<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.MemberDao" %>
<%@ page import = "java.io.PrintWriter" %>
<%
request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="member" class="dto.Member"  scope="page"></jsp:useBean>
<jsp:setProperty name = "member" property = "memberID"/>
<jsp:setProperty name = "member" property = "memberPassword"/>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!doctype html>
<html lang="en" data-bs-theme="auto">
  <head><!--<script src="assets/js/color-modes.js">--></script>
<!--../ 상대주소   /절대주소-->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.115.4">
    <title>멤버,보드연동프로젝트</title>

    <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
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
			<a class="navbar-brand" href="loginForm.jsp">멤버,보드연동프로젝트</a>
		</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="loginForm.jsp">메인</a></li>
				<li><a href="board.jsp">게시판</a></li>
			
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
				<a href="#" class ="dropdown-toggle" data-toggle="dropdown" 
					role="button" aria-haspopup="true" aria-expanded="false">
					접속하기
						<span class="caret"></span>
				</a>
				<ul class="dropdown-menu">
					<li><a href="login.jsp">로그인</a>
					<li class="active"><a href="join.jsp">회원가입</a>
				</ul>
			
		</div>
	</nav>
	<div class="container">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<div class="jumbotron" style="padding-top:20px;">
				<form method="post" action="joinAction.jsp">
					<h3 style="text-align:center;">회원가입화면</h3>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="아이디" name="memberID" maxlength="20"/>
					</div>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="비밀번호" name="memberPassword" maxlength="20"/>
					</div>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="이름" name="memberName" maxlength="20"/>
					</div>
					<div class="form-group" style="text-align; center;">
						<div class="btn-group" data-toggle="buttons">
							<label class="btn btn-primary active">
								<input type="radio" name="memberGender" autocomplete="off" value="남자" checked/>남자
							</label>
							<label class="btn btn-primary">
								<input type="radio" name="memberGender" autocomplete="off" value="여자" checked/>여자
							</label>
						</div>
					</div>
					<div class="form-group">
						<input type="email" class="form-control" placeholder="이메일" name="memberEmail" maxlength="20"/>
					</div>
					
					<input type="submit" class="btn btn-primary form-control" value="회원가입">
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
      	int result = memberDao.login(member.getMemberID(),member.getMemberPassword()) ;
      	if(result == 1){
      		PrintWriter script = response.getWriter();
      		script.println("<script>");
      		script.println("location.href = 'loginForm.jsp");
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
