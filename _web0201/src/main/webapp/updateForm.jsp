<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
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
String sql = "select ename, job, sal from emp1 where ename = ?";
PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setString(1, request.getParameter("ename"));
ResultSet rs = pstmt.executeQuery();
String ename = ""; String job = ""; String sal = "";

if(rs.next()){
	ename = rs.getString("ename");
	job = rs.getString("job");
	sal = rs.getString("sal");
}
%>


<form action = "update.jsp" method = "post">
이름 : <input type = "text" name = "ename" value="<%= ename%>"/><br/>
직무 : <input type = "text" name = "job" value="<%=job %>"/><br/>
월급 : <input type = "text" name = "sal" value="<%=sal%>"/><br/>
<input type = "submit" value = "수정"/>
<input type = "reset" value = "리셋"/>

</form>
<a href="index.jsp">홈으로</a>
</body>
</html>