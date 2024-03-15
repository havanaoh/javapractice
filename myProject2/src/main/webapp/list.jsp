
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	MemberDto member = (MemberDto)session.getAttribute("member");
	if(member == null){
		response.sendRedirect("loginForm.jsp");
	}
	request.setAttribute("num", member.getMemberno());
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        table     { width:680px; text-align:center; }
        th        { background-color:cyan; }

        .num      { width: 80px; }
        .title    { width:230px; }
        .writer   { width:100px; }
        .regtime  { width:180px; }

        a:link    { text-decoration:none; color:blue; }
        a:visited { text-decoration:none; color:gray; }
        a:hover   { text-decoration:none; color:red;  }

        .pgn:visited { text-decoration:none; color:blue; }
    </style>
</head>
<body>

<input type="button" value="마이페이지"
       onclick="location.href='mview?num=${num}'">
<input type="button" value="로그아웃"
       onclick="location.href='loginForm'">
<table>
    <tr>
        <th class="boardno"    >번호    </th>
        <th class="title"  >    제목    </th>
        <th class="MEMBERNO" >  작성자  </th>
        <th class="regtime">    작성일시</th>
        <th                >    조회수  </th>
    </tr>

    <c:forEach var="msg" items="${msgList}">
    <tr>
        <td>${msg.boardno}</td>
        <td style="text-align:left;">
            <a href="view?num=${msg.boardno}&page=${param.page}">
                ${msg.title}
            </a>
        </td>
       	<td>${msg.name}</td>
        <td>${msg.regtime}</td>
        <td>${msg.hits}</td>
    </tr>
    </c:forEach>
</table>

<br>
<div style="width:680px; text-align:center;">
    <c:forEach var="pgn" items="${pgnList}">
         <a class="pgn" href="list?page=${pgn.pageNo}">
             <c:choose>
                 <c:when test="${pgn.curPage}">
                     <u>${pgn.display}</u>
                 </c:when>
                 <c:otherwise>
                     ${pgn.display}
                 </c:otherwise>
             </c:choose>
         </a>&nbsp;
    </c:forEach>
</div>

<br>
<input type="button" value="글쓰기" onclick="location.href='write'">

</body>
</html>