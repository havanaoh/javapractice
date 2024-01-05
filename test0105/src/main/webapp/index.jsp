<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.Date" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>연습용 페이지입니다. <h1>
<%! // 선언하기
public static String print(){
	return "안녕 세상아!!!!!!";
}
%>
<h3><%=print() %><h3>
<%
int sum=0;
for(int i=0; i<=10; i++){
	sum +=i;
}
%>
<h2><%=sum %><h2>


<%
Date now = new Date();
%>
<%=now %>
<%

%>

</body>
</html>