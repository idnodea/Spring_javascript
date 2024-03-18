
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberDto memberDto = (MemberDto)session.getAttribute("member");
	//System.out.println("write에서 찍히는:"+memberDto);
	
	//추가
	if(memberDto == null){
		//response.sendRedirect("list.jsp");
		response.sendRedirect("loginForm.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        table { width:680px; text-align:center; }
        th    { width:100px; background-color:cyan; }
        input[type=text], textarea { width:100%; }
    </style>
</head>
<body>

<form method="post" action="${action}">
    <table>
        <tr>
            <th>제목</th>
            <td><input type="text" name="title"  maxlength="80"
                       value="${msg.title}">
            </td>
        </tr>
        <tr>
            <th>작성자</th>
            <td><input type="text" name="writer" maxlength="20" readonly="readonly"
                       value="<%=memberDto.getName() %>">

            </td>
        </tr>
        <tr>
            <th>내용</th>
            <td><textarea name="content" rows="10">${msg.content}</textarea>
            </td>
        </tr>
    </table>

    <br>
    <input type ="hidden" name = "memberno" value="<%=memberDto.getMemberno() %>">
    <input type="submit" value="저장">
    <input type="button" value="취소" onclick="history.back()">
</form>

</body>
</html>