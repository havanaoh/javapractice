<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Cookie ck = new Cookie("loginId","admin");
// ck.setMaxAge(60*60*24*30); // 초단위 기본값은 -1, 브라우저 닫으면 삭제
response.addCookie(ck);
%>
<%= ck.getName() %>
<br/>
<%= ck.getValue() %>
</body>
</html>