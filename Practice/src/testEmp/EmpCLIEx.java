package testEmp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmpCLIEx {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/firm";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "mysql";
    static Scanner scanner = new Scanner(System.in);
    static Statement stmt = null; 
    static ResultSet rs = null;
    int empno, mgr, deptno;
    double sal, comm;
    String ename, job, hiredate, sql, sql2;
    
	public static void main(String[] args) {
		EmpCLIEx ec = new EmpCLIEx();
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
           	boolean exit = false;           	
            while (!exit) {
                System.out.println("1. 데이터 전체 보기 | 2. 데이터 검색 |"
                		+ " 3. 데이터 추가 | 4. 데이터 수정 | 5. 데이터 삭제 | 6.종료");
                System.out.print("선택하세요: ");
                String choice = scanner.nextLine();
                switch (choice) {
                	case "1":                    	
                		ec.viewData(connection);
                    break;
                    case "2":                    	
                    	ec.searchData(connection);
                        break;
                    case "3":
                    	ec.insertData(connection);
                        break;
                    case "4":
                    	ec.updateData(connection);
                        break;
                    case "5":
                    	ec.deleteData(connection);
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
		System.out.println("전체 데이터");
		try {
			stmt = connection.createStatement();
			sql = "select * from emp";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				empno = rs.getInt("empno");
				ename = rs.getString("ename");
				job = rs.getString("job");
				mgr = rs.getInt("mgr");
				hiredate = rs.getString("hiredate");
				sal = rs.getDouble("sal");
				comm = rs.getDouble("comm");
				deptno = rs.getInt("deptno");
				String sql2 = (empno + "\t" + ename + "\t"+ job + "\t"
				+ mgr + "\t"+ hiredate + "\t"+ sal + "\t" + comm + "\t"
				+ deptno);
				System.out.println(sql2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private void searchData(Connection connection) {
		System.out.println("검색할 사번을 입력하세요 : ");
		empno = Integer.parseInt(scanner.nextLine());
		sql = "select * from emp where empno = '" + empno + "'";
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.print(rs.getInt("empno")+"\t");
				System.out.print(rs.getString("ename")+"\t");
				System.out.print(rs.getString("job")+"\t");
				System.out.print(rs.getInt("mgr")+"\t");
				System.out.print(rs.getString("hiredate")+"\t");
				System.out.print(rs.getDouble("sal")+"\t");
				System.out.print(rs.getDouble("comm")+"\t");
				System.out.println(rs.getInt("deptno"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void insertData(Connection connection) {
		System.out.println("등록할 사원의 정보를 입력해주세요 : ");
		System.out.print("사원번호:");
		empno = Integer.parseInt(scanner.nextLine());
		System.out.print("사원명:");
		ename = scanner.nextLine();
		System.out.print("mgr:");
		
		System.out.print("입사일:");
		hiredate = scanner.nextLine();
		System.out.print("연봉:");
		sal = scanner.nextDouble();
		System.out.print("성과금:");
		comm = scanner.nextDouble();
		System.out.print("부서번호:");
		deptno = Integer.parseInt(scanner.nextLine());
	}
	
	private void updateData(Connection connection) {
		
	}
	
	private void deleteData(Connection connection) {
		
	}
	
	
	
	
	
	
}
