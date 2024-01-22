package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcEx {

	public static void main(String[] args) 
			throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/company";
		String id = "root";
		String pass = "mysql";
		Class.forName("com.mysql.cj.jdbc.Driver");
		//객체 등록
		System.out.println("mysql 드라이버 로딩 성공");
		Connection conn = DriverManager.getConnection(url, id, pass);
		System.out.println("mysql 접속 성공");
		Statement stmt = conn.createStatement();
		// 데이터 보내기 위한 명령문
		ResultSet rs = stmt.executeQuery("select * from emp");
		// 데이터 읽는 실행문
		while(rs.next()) {
//			int deptno = rs.getInt("deptno");
//			String dname = rs.getString("dname");
//			String loc = rs.getString("loc");
//			System.out.printf("%d, %s, %s\n", deptno, dname, loc);
			String ename = rs.getString("ename");
			double sal = rs.getDouble("sal");
			System.out.printf("%s, %10.2f\n", ename, sal);
		}
		
		
		conn.close();
	}

}
