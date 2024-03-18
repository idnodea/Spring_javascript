
<%@page import="mvjsp.board.model.Member"%>
<%@page import="mvjsp.board.dao.MemberDao"%>
<%@page import="mvjsp.jdbc.connection.ConnectionProvider"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//Class.forName("oracle.jdbc.driver.OracleDriver");
//Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
//String sql = "select * from member";
//PreparedStatement pstmt = conn.prepareStatement(sql);
//ResultSet rs = pstmt.executeQuery();

Connection conn = ConnectionProvider.getConnection();
MemberDao dao = MemberDao.getInstance();
ArrayList<Member> mList = dao.selectAll(conn);
request.setAttribute("mList", mList);
%>
<jsp:forward page="list_view.jsp"></jsp:forward>