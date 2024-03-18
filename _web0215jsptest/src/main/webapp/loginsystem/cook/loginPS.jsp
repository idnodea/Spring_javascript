<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
	
    boolean login = false;
    //System.out.println(pw);
    Class.forName("oracle.jdbc.driver.OracleDriver");
    //String sql="select count(*) as cnt from score where num = ? and name = ? ";
    String sql="select count(*) as cnt from score where num = ? and name = ? ";
    try ( 
        Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
        
    		
    	PreparedStatement pstmt = conn.prepareStatement(sql);
    	
    ) {
    	pstmt.setInt(1, Integer.parseInt(id));
        pstmt.setString(2, pw);
        ResultSet rs = pstmt.executeQuery();
		
         rs.next();   //next()가 null일 수가 없으니까.  0이면 모를까
         int res= rs.getInt("cnt");  //별칭써도 괜찮음
        // System.out.println(res);
         
         if(res == 1){
        	login = true;
         }
         
    } catch(Exception e) {
       System.out.println("오류!");
       e.printStackTrace();
    }
    
    //if (id.equals("admin") && pw.equals("1234")) {
    if (login) {
        Cookie cookie = new Cookie("userId", id);
        cookie.setMaxAge(-1);         // 웹 브라우저가 닫힐 때 쿠키 만료됨
        response.addCookie(cookie);
        
        response.sendRedirect("index.jsp");   // 로그인 메인 화면으로 돌아감
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>

<script>
    alert('아이디 또는 비밀번호가 틀립니다!');
    history.back();
</script>
 
</body>
</html>