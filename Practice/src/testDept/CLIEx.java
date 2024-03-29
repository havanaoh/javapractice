package testDept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CLIEx {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/firm";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "mysql";
    static Scanner scanner = new Scanner(System.in);
    static Statement stmt = null; 
    static ResultSet rs = null;
    int deptno;
    String dname, dname2, loc, sql, sql2;
    
    public static void main(String[] args) {
    	CLIEx cl = new CLIEx();    	
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
           	boolean exit = false;           	
            while (!exit) {
                System.out.println("1. 데이터 전체 보기 | 2. 데이터 검색 |"
                		+ " 3. 데이터 추가 | 4. 데이터 수정 | 5. 데이터 삭제 | 6.종료");
                System.out.print("선택하세요: ");
                String choice = scanner.nextLine();
                switch (choice) {
                	case "1":                    	
                		cl.viewData(connection);
                    break;
                    case "2":                    	
                    	cl.searchData(connection);
                        break;
                    case "3":
                    	cl.insertData(connection);
                        break;
                    case "4":
                    	cl.updateData(connection);
                        break;
                    case "5":
                    	cl.deleteData(connection);
                        break;
                    case "6":
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
     
	private void viewData(Connection connection) {
		try {
			stmt = connection.createStatement();
			String sql = "select * from dept";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				deptno = rs.getInt("deptno");
				dname = rs.getString("dname");
				loc = rs.getString("loc");
				String sql2 = (deptno + "\t" + dname + "\t" + loc);
				System.out.println(sql2);
			}
		} catch (SQLException e) {
		}
	}
	
	private void searchData(Connection connection) {
		System.out.print("부서명을 입력하세요 : ");
		dname2 = scanner.nextLine();
			sql = "select * from dept where dname = '" + dname2 + "'";
			try {
				stmt = connection.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					System.out.print(rs.getInt("deptno")+"\t");
					System.out.print(rs.getString("dname")+"\t");
					System.out.println(rs.getString("loc"));
				}			
			} catch (SQLException e) {				
				e.printStackTrace();
			}
    }

    private void insertData(Connection connection) {    	
    	System.out.print("부서번호:");
		int deptno = Integer.parseInt(scanner.nextLine());
		System.out.print("부서이름:");
		String dname = scanner.nextLine();
		System.out.print("부서위치:");
		String loc = scanner.nextLine();
		String sql = "insert into dept(deptno, dname, loc) values ('"
		+deptno+"', '"+dname+"', '"+loc+"')";
		try {
			stmt = connection.createStatement();
			int result = stmt.executeUpdate(sql);
			} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(sql);
    }
    
    private void updateData(Connection connection) {
    	System.out.println("수정할 정보를 입력하세요");
    	System.out.print("부서번호 :");
    	deptno = Integer.parseInt(scanner.nextLine());
    	System.out.print("부서이름 :");
    	dname = scanner.nextLine();
    	System.out.print("부서위치 :");
    	loc = scanner.nextLine();
    	try {
			stmt = connection.createStatement();
			sql = "update dept set dname = '"+dname+"', loc = '"+loc
				+"' where deptno = "+deptno;
			System.out.println(sql);
			int rs = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    private void deleteData(Connection connection) {
    	System.out.println("삭제할 부서번호를 입력하세요 : ");
    	deptno = Integer.parseInt(scanner.nextLine());
    	try {
			stmt = connection.createStatement();
			sql = "delete from dept where deptno = " + deptno;
			int rs = stmt.executeUpdate(sql) ;			
		} catch (SQLException e) {
			e.printStackTrace();
		}    	
    }

}
