<%@page import="mvjsp.board.model.Member"%>
<%@page import="java.util.ArrayList"%>
<%@page import="mvjsp.board.dao.MemberDao"%>
<%@page import="mvjsp.jdbc.connection.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Connection conn = ConnectionProvider.getConnection();
MemberDao dao = MemberDao.getInstance();
ArrayList<Member> Mlist = dao.selectAll(conn);
request.setAttribute("Mlist", Mlist);
%>

<jsp:forward page="list_view.jsp" />


