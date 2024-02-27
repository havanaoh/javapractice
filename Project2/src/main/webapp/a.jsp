<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% 
 	String str = request.getParameter("name"); 
 %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="b.jsp">b page로 이동</a><br>
<a href="https://www.naver.com">naver 로 이동</a><br>
<a href="index.jsp">home</a><br>
<%=str %>

</body>
</html>