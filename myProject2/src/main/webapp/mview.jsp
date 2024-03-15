<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberDto member = (MemberDto)session.getAttribute("member");
	if(member == null){
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
        td    { text-align:left; border:1px solid gray; }
    </style>
</head>
<body>

<table>
    <tr>
        <th>아이디</th>
        <td>${member.id}</td>
    </tr>
    <tr>
        <th>이메일</th>
        <td>${member.email}</td>
    </tr>
    <tr>
        <th>이름</th>
        <td>${member.name}</td>
    </tr>
    
</table>

<br>
<input type="button" value="목록보기" onclick="location.href='list'">
<input type="button" value="수정"
       onclick="location.href='mwrite?num=${member.memberno}'">
<input type="button" value="삭제"
       onclick="location.href='mdelete?num=${member.memberno}'">

</body>
</html>