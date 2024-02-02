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
Connection conn = null;

Class.forName("oracle.jdbc.driver.OracleDriver");
try { 
    conn = DriverManager.getConnection(
            "jdbc:oracle:thin:@localhost:1521:xe", "scott", "tigger");
    String sql = "delete from score where stNum = ?";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setInt(1, Integer.parseInt(request.getParameter("stNum")));
    pstmt.executeUpdate();
    
} catch(Exception e) {
    e.printStackTrace();
	
} finally {
    if (conn != null) 
          conn.close();
}

response.sendRedirect("score.jsp"); %>

</body>
</html>