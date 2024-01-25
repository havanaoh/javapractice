package jbdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class SimpleMenu2{

    private static final String DB_URL = "jdbc:mysql://localhost:3306/firm";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "mysql";
    static Scanner scanner = new Scanner(System.in);
    static Statement stmt = null;

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            boolean exit = false;

            while (!exit) {
                System.out.println("1. 데이터 보기");
                System.out.println("2. 데이터 삽입");
                System.out.println("3. 종료");
                System.out.print("선택하세요: ");

                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        viewData(connection);
                        break;
                    case "2":
                        insertData(connection);
                        break;
                    case "3":
                        exit = true;
                        break;
                    default:
                        System.out.println("유효하지 않은 선택. 다시 시도하세요.");
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void viewData(Connection connection) {
        try {
			stmt = connection.createStatement();
			String sql = "select * from dept";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				String sql2 = (deptno + "\t" + dname + "\t" + loc);
				System.out.println(sql2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }

    private static void insertData(Connection connection) {
        
    }
}

