<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<form action="login">
아이디 : <input type="text" name="id"><br>
이메일 : <input type="text" name="email"><br>
<input type="submit">
<input type="button" value="회원가입"
       onclick="location.href='signUp.jsp'">
</form>
</body>
</html>