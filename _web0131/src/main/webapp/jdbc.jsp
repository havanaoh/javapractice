<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@ page import="java.sql.ResultSet" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <style>
        /* 들여쓰기에 사용할 공백 크기를 지정합니다. */
        pre {
            white-space: pre-wrap; /* 공백 유지 및 줄 바꿈 유지 */
            tab-size: 10; /* 탭 크기, 원하는 크기로 조절 */
            
        }
    </style>
</head>
<body>
<%
try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    String url = "jdbc:mysql://localhost:3306/firm";
    String id = "root";
    String pass = "mysql";
    Connection conn = DriverManager.getConnection(url, id, pass);
    Statement stmt = conn.createStatement();

    String sql = "select * from emp";
    ResultSet rs = stmt.executeQuery(sql);
	
    out.println("<pre>");
    
    // ResultSet에서 데이터를 가져오는 코드를 여기에 추가
	while (rs.next()) {
		int	empno = rs.getInt("empno");
		String ename = rs.getString("ename");
		String job = rs.getString("job");
		int mgr = rs.getInt("mgr");
		String hiredate = rs.getString("hiredate");
		double sal = rs.getDouble("sal");
		double comm = rs.getDouble("comm");
		int deptno = rs.getInt("deptno");
		out.print("empno: " + empno + "\t ename: " + ename +
                "\t  job: " + job + "\t  mgr: " + mgr +
                "\t  hiredate: " + hiredate + "\t  sal: " + sal +
                "\t  comm: " + comm + "\t  deptno: " + deptno + "<br>");
	}	
	
    out.println("</pre>");
    
	// 리소스를 올바르게 관리하기 위해 ResultSet, Statement 및 Connection을 닫습니다.
    rs.close();
    stmt.close();
    conn.close();
} catch (Exception e) {
    e.printStackTrace();
}
%>

</body>
</html>