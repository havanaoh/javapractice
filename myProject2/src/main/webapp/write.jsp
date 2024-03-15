<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberDto member = (MemberDto)session.getAttribute("member");
	if(member == null){
		response.sendRedirect("loginForm.jsp");
	}
		
	request.setAttribute("name", member.getName());
	request.setAttribute("num", member.getMemberno());
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

<form method="post" action="insert">
    <table>
        <tr>
            <th>제목</th>
            <td><input type="text" name="title"  maxlength="80"
                       value="${title}">
            </td>
        </tr>
        <tr>
            <th>작성자</th>
            <td><input type="text" name="name" maxlength="20"
                       value="${name}">
            </td>
        </tr>
        <tr>
            <th>내용</th>
            <td><textarea name="content" rows="10">${content}</textarea>
            </td>
        </tr>
    </table>

    <br>
<input type="hidden" name="num" value="${num }">
    <input type="submit" value="저장" >
    <input type="button" value="취소" onclick="history.back()">
</form>

</body>
</html>