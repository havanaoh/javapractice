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
Connection conn = null;

Class.forName("oracle.jdbc.driver.OracleDriver");
try { 
    conn = DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:xe", "scott", "tigger");
	
    String sql = "insert into score (stNum, name, kor, eng, math) values(?, ?, ?, ?, ?)";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, request.getParameter("stNum"));
    pstmt.setString(2, request.getParameter("name"));
    pstmt.setInt(3, Integer.parseInt(request.getParameter("kor")));
    pstmt.setInt(4, Integer.parseInt(request.getParameter("eng")));
    pstmt.setInt(5, Integer.parseInt(request.getParameter("math")));
    int result = pstmt.executeUpdate();
    
} catch(Exception e) {
    e.printStackTrace();
	
} finally {
    if (conn != null) 
          conn.close();
}

response.sendRedirect("score.jsp");

%>





</body>
</html>