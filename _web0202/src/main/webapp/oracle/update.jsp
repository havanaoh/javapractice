<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
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
request.setCharacterEncoding("utf-8");
String driver = "oracle.jdbc.driver.OracleDriver";
String url = "jdbc:oracle:thin:@localhost:1521:xe";
Class.forName(driver);
Connection conn = DriverManager.getConnection(url, "scott", "tigger");
String sql = "update score set kor = ? , math = ? , eng = ? " 
			+ "where stNum = ?";
PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setString(1, request.getParameter("kor"));
pstmt.setString(2, request.getParameter("math"));
pstmt.setString(3, request.getParameter("eng"));
pstmt.setString(4, request.getParameter("stNum"));
pstmt.executeUpdate();
response.sendRedirect("score.jsp");
%>
</body>
</html>