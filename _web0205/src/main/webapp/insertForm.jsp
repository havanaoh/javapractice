<%@page import="java.sql.ResultSet"%>
<%@page import="org.eclipse.jdt.internal.compiler.parser.RecoveredRequiresStatement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 입력</title>
</head>
<body>

<form action = "insert.jsp" method = "post">
학번 : <input type = "text" name = "num" /><br/>
이름 : <input type = "text" name = "name"/><br/>
국어 : <input type = "text" name = "kor" /><br/>
영어 : <input type = "text" name = "eng" /><br/>
수학 : <input type = "text" name = "math"/><br/>

<input type = "submit" value = "확인"/>
<input type = "reset" value = "리셋"/>


</form>
<a href="index.jsp">홈으로</a>

</body>
</html>