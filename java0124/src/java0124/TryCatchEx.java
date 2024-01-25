package java0124;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TryCatchEx {

	public static void main(String[] args) {
		String str;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// 예외 처리 코드
			System.out.println("error!!");
//			e.printStackTrace();
			System.exit(0);
		}finally {
			System.out.println("반드시 실행");
		}
		try {
			Connection conn = DriverManager.getConnection(null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
