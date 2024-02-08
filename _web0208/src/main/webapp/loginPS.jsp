<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");
	boolean login = false;
    
    Class.forName("oracle.jdbc.driver.OracleDriver");
    String sql = "select count(*) as cnt from score where num = ? and name = ?";
    try ( 
        Connection conn = DriverManager.getConnection(
        		"jdbc:oracle:thin:@localhost:1521:xe", "scott", "tigger");  	
        PreparedStatement pstmt = conn.prepareStatement(sql);
    		
         
    ) {
       pstmt.setString(1, id);
       pstmt.setString(2, pw);
       ResultSet rs = pstmt.executeQuery();
       
       rs.next(); // 안써주면 결과값을 받을수가 없음
       int res = rs.getInt("cnt");
       
       if(rs.getInt(1)==1){ // count 값은 null이 나오지않음
    	   login = true;
       }

    } catch(Exception e) {
    	System.out.println("오류!");
    }
    
    if (login) {
        Cookie cookie = new Cookie("userId", id);
        cookie.setMaxAge(-1);         // 웹 브라우저가 닫힐 때 쿠키 만료됨
        response.addCookie(cookie); // 파일로 쿠키 저장함
        
        response.sendRedirect("loginCK.jsp");   // 로그인 메인 화면으로 돌아감
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
 
<script>
    alert('아이디 또는 비밀번호가 틀립니다!');
    history.back();
</script>
 
</body>
</html>