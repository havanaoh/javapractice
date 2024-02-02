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
String sql = "select stNum, name, kor, math, eng from score where stNum = ?";
PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setString(1, request.getParameter("stNum"));
ResultSet rs = pstmt.executeQuery();
String stNum = ""; String name = ""; String kor = ""; String math = ""; 
String eng = ""; 

if(rs.next()){
	stNum = rs.getString("stNum");
	name = rs.getString("name");
	kor = rs.getString("kor");
	math = rs.getString("math");
	eng = rs.getString("eng");
}
%>


<form action = "update.jsp" method = "post">
학번	   : <input type = "text" name = "stNum"	value = "<%=stNum = rs.getString("stNum") %>"/><br/>
이름	   : <input type = "text" name = "name"		value = "<%=name = rs.getString("name") %>"/><br/>
국어 성적 : <input type = "text" name = "kor" 		value = "<%=kor = rs.getString("kor") %>"/><br/>
수학 성적 : <input type = "text" name = "eng" 		value = "<%=math = rs.getString("math") %>"/><br/>
영어 성적 : <input type = "text" name = "math"		value = "<%=eng = rs.getString("eng") %>"/><br/>
<input type = "submit" value = "수정"/>
<input type = "reset" value = "리셋"/>

</form>
<a href="index.jsp">홈으로</a>
</body>
</html>