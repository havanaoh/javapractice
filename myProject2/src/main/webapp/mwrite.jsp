<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	MemberDto member = (MemberDto)session.getAttribute("member");
	if(member == null){
		response.sendRedirect("loginForm.jsp");
	}	
	request.setAttribute("memberno", member.getMemberno());
	request.setAttribute("id", member.getId());
	request.setAttribute("name", member.getName());
	request.setAttribute("email", member.getEmail());
	
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

<form method="post" action="mupdate?num=${member.memberno}">
    <table>
        <tr>
            <th>이름</th>
            <td><input type="text" name="name"  maxlength="80"
                       value="${member.name}">
            </td>
        </tr>
        <tr>
            <th>이메일</th>
            <td><input type="text" name="email" maxlength="20"
                       value="${member.email}">
            </td>
        </tr>
    </table>

    <br>

    <input type="submit" value="저장" >
    <input type="button" value="취소" onclick="history.back()">
</form>

</body>
</html>