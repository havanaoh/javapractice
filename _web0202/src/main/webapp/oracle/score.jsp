<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>   
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
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
<%    Class.forName("oracle.jdbc.driver.OracleDriver");
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
                <td><button onclick="location.href='delete.jsp?stNum=<%=rs.getInt("stNum")%>'">삭제</button></td>
                <td><button onclick="location.href='updateForm.jsp?stNum=<%=rs.getInt("stNum")%>'">수정</button></td>
            </tr>
<%        }
        
    } catch(Exception e) {
        e.printStackTrace();
    }
%>
</table>
<table>

    <thead>
        <tr>
            <th>과목</th>
            <th>최고점</th>
            <th>전체평균</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>국어</td>
            <td>최고점 데이터</td>
            <td>전체평균 데이터</td>
        </tr>
        <tr>
            <td>영어</td>
            <td>최고점 데이터</td>
            <td>전체평균 데이터</td>
        </tr>
        <tr>
            <td>수학</td>
            <td>최고점 데이터</td>
            <td>전체평균 데이터</td>
        </tr>
    </tbody>
</table>
<button onclick="location.href='index.jsp'">홈으로</button>
</body>
</html>