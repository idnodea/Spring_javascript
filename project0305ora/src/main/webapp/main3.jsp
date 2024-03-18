<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import = "java.io.PrintWriter" %>
<%
	String id = "";
	Cookie[] cookies = request.getCookies(); 
	if(cookies !=null){
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("id")){
				id = cookie.getValue();
				break;
			}
		}
	}
%>
    
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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@docsearch/css@3">
	<link href="assets/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }

      .b-example-divider {
        width: 100%;
        height: 3rem;
        background-color: rgba(0, 0, 0, .1);
        border: solid rgba(0, 0, 0, .15);
        border-width: 1px 0;
        box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
      }

      .b-example-vr {
        flex-shrink: 0;
        width: 1.5rem;
        height: 100vh;
      }

      .bi {
        vertical-align: -.125em;
        fill: currentColor;
      }

      .nav-scroller {
        position: relative;
        z-index: 2;
        height: 2.75rem;
        overflow-y: hidden;
      }

      .nav-scroller .nav {
        display: flex;
        flex-wrap: nowrap;
        padding-bottom: 1rem;
        margin-top: -1px;
        overflow-x: auto;
        text-align: center;
        white-space: nowrap;
        -webkit-overflow-scrolling: touch;
      }

      .btn-bd-primary {
        --bd-violet-bg: #712cf9;
        --bd-violet-rgb: 112.520718, 44.062154, 249.437846;

        --bs-btn-font-weight: 600;
        --bs-btn-color: var(--bs-white);
        --bs-btn-bg: var(--bd-violet-bg);
        --bs-btn-border-color: var(--bd-violet-bg);
        --bs-btn-hover-color: var(--bs-white);
        --bs-btn-hover-bg: #6528e0;
        --bs-btn-hover-border-color: #6528e0;
        --bs-btn-focus-shadow-rgb: var(--bd-violet-rgb);
        --bs-btn-active-color: var(--bs-btn-hover-color);
        --bs-btn-active-bg: #5a23c8;
        --bs-btn-active-border-color: #5a23c8;
      }
      .bd-mode-toggle {
        z-index: 1500;
      }
    </style>
<body>
<%
	String userID = null;
	if(session.getAttribute("userID") != null){
		userID = (String) session.getAttribute("userID");
	}
%>

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
				<li class="active"><a href="main.jsp">메인</a></li>
				<li><a href="bbs.jsp">게시판</a></li>
			
			</ul>
			<%
				if(userID ==null){
			%>	
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
				<a href="#" class ="dropdown-toggle" data-toggle="dropdown" 
					role="button" aria-haspopup="true" aria-expanded="false">
					접속하기
						<span class="caret"></span>
				</a>
				<ul class="dropdown-menu">
					<li><a href="login.jsp">로그인</a>
					<li><a href="join.jsp">회원가입</a>
				</ul>
			<% 	
				}else{
			%>
			 <ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
				<a href="#" class ="dropdown-toggle" data-toggle="dropdown" 
					role="button" aria-haspopup="true" aria-expanded="false">
					회원관리
						<span class="caret"></span>
				</a>
				<ul class="dropdown-menu">
					<li><a href="logout.jsp">로그아웃</a>
					
					
			 </ul>
			<%
				}
			%>
			
		</div>
	</nav>
	
	<div>
		<h1 style="font-size: 24px;">Hellow</h1>
		<div class="form-check text-start my-3">
    	  <input class="form-check-input" type="checkbox" value="remember-me" id="flexCheckDefault" onclick="setCookie()" checked name="ck" checked/>
     	  <label class="form-check-label" for="flexCheckDefault">
      		  아이디 저장
    	  </label>
   		 </div>
	</div>
	
<script>
	function setCookie() {
	    var checkBox = document.getElementById("flexCheckDefault");
	    if (checkBox.checked) {
	        // 쿠키 이름과 값을 설정
	        var cookieName = "rememberMe";
	        var cookieValue = "true";
	        
	        // 쿠키 만료일 설정 (예: 1일)
	        var expirationDate = new Date();
	        expirationDate.setDate(expirationDate.getDate() + 1);
	        
	        // 쿠키 문자열 생성
	        var cookieString = cookieName + "=" + cookieValue + "; expires=" + expirationDate.toUTCString() + "; path=/";
	        
	        // 쿠키 설정
	        document.cookie = cookieString;
	    } else {
	        // 체크박스가 선택되지 않았을 때, 쿠키를 제거
	        document.cookie = "rememberMe=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
	    }
	}
</script>
	
<script src="assets/dist/js/bootstrap.bundle.min.js"></script>	
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
</body>
  

</html>
