<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 입력</title>
    <style>
        table { width: 400px; text-align: center; }
        th    { background-color: skyblue; }
    </style>  
</head>
<body>
<table>
    <tr>
        <th>번호</th><th>이름</th>
        <th>국어</th><th>영어</th><th>수학</th>
        <th>총점</th><th>평균</th>
    </tr>
<%
    Class.forName("oracle.jdbc.driver.OracleDriver");
    try ( 
        Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe", "scott", "tigger");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from score");
    ) {
        while (rs.next()) {
            int sum = rs.getInt("kor") + rs.getInt("eng") + 
                      rs.getInt("math");
%>          
            <tr>
                <td><%=rs.getInt   ("stNum" )%></td>
                <td><%=rs.getString("name")%></td>
                <td><%=rs.getInt   ("kor" )%></td>
                <td><%=rs.getInt   ("eng" )%></td>
                <td><%=rs.getInt   ("math")%></td>
                <td><%=sum%></td>
                <td><%=String.format("%.2f", (float)sum / 3)%></td>
                
            </tr>
<%          
        }
        
    } catch(Exception e) {
        e.printStackTrace();
    }
%>
</table>

<form action = "insert.jsp" method = "post">
학번	   : <input type = "text" name = "stNum"/><br/>
이름	   : <input type = "text" name = "name"/><br/>
국어 성적 : <input type = "text" name = "kor" /><br/>
수학 성적 : <input type = "text" name = "eng" /><br/>
영어 성적 : <input type = "text" name = "math"/><br/>
<input type = "submit" value = "입력"/>
<input type = "reset" value = "리셋"/>

</form>


</body>
</html>