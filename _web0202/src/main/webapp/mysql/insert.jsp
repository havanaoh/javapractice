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

<%request.setCharacterEncoding("utf-8");
String driver = "com.mysql.cj.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/firm";
Class.forName(driver);
Connection conn = DriverManager.getConnection(url, "root", "mysql");
String sql = "insert into score (num, name, kor, eng, math) values(?, ?, ?, ?, ?)";
PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setInt(1, Integer.parseInt(request.getParameter("num")));
pstmt.setString(2, request.getParameter("name"));
pstmt.setInt(3, Integer.parseInt(request.getParameter("kor")));
pstmt.setInt(4, Integer.parseInt(request.getParameter("eng")));
pstmt.setInt(5, Integer.parseInt(request.getParameter("math")));
int result = pstmt.executeUpdate();
response.sendRedirect("mysqlList.jsp");

%>

</body>
</html>