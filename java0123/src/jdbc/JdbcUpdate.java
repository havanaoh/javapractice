package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUpdate {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/firm";
		String id = "root";
		String pass = "mysql";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, id, pass);
		Statement stmt = conn.createStatement();
		String sql = "delete from emp where empno = 7777";
		int result = stmt.executeUpdate(sql); // 성공한 행의 수가 나옴
		if (result >= 1) {
			System.out.println("삭제 성공!" + result);
		}else {
			System.out.println("삭제 실패 :("+ result);
		}
		
	}

}
