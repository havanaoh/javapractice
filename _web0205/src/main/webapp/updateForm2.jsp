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
<%
String url ="jdbc:oracle:thin:@localhost:1521:xe";
Connection conn = DriverManager.getConnection(url, "scott", "tigger");
String sql = "select * from score where num = ?";
PreparedStatement pstmt = conn.prepareStatement(sql);
pstmt.setString(1, request.getParameter("num"));
ResultSet rs = pstmt.executeQuery();
String num="";
String name="";
String kor="";
String eng="";
String math="";

if(rs.next()){ // 왜 if 일까? 무조건 1건(행, 레코드)
	num = rs.getString("num");
	name = rs.getString("name");
	kor = rs.getString("kor");
	eng = rs.getString("eng");
	math = rs.getString("math");
}

%>

<form method = "post" id="frm">
학번	   : <input type = "text" name = "num" value="<%=num%>"/><br/>
이름	   : <input type = "text" name = "name"value="<%=name%>"/><br/>
국어 성적 : <input type = "text" name = "kor" value="<%=kor%>"/><br/>
수학 성적 : <input type = "text" name = "eng" value="<%=eng%>"/><br/>
영어 성적 : <input type = "text" name = "math"value="<%=math%>"/><br/>
</form>
<a href="index.jsp">홈으로</a>
<input type="button" onClick="update()" value="수정">
<button onClick="delete2()">삭제</button>
<script>
function delete2() {
	document.getElementById('frm').action='delete.jsp';
	document.getElementById('frm').submit();
}
function update() {
	document.getElementById('frm').action='update.jsp';
	document.getElementById('frm').submit();
}
</script>
</body>
</html>