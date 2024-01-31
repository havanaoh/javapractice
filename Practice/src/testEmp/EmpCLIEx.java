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
	private static Scanner scanner = new Scanner(System.in);
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private int empno, mgr, deptno;
	private double sal, comm;
	private String ename, job, hiredate, sql;

	public static void main(String[] args) {
		EmpCLIEx ec = new EmpCLIEx();
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
			boolean exit = false;
			while (!exit) {
				System.out.println("1. 데이터 전체 보기 | 2. 데이터 검색 |" + " 3. 데이터 추가 | 4. 데이터 수정 | 5. 데이터 삭제 | 6.종료");
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
					System.out.println("시스템을 종료합니다");
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
			while (rs.next()) {
				empno = rs.getInt("empno");
				ename = rs.getString("ename");
				job = rs.getString("job");
				mgr = rs.getInt("mgr");
				hiredate = rs.getString("hiredate");
				sal = rs.getDouble("sal");
				comm = rs.getDouble("comm");
				deptno = rs.getInt("deptno");
				String sql2 = (empno + "\t" + ename + "\t" + job + "\t" + mgr + "\t" + hiredate + "\t" + sal + "\t"
						+ comm + "\t" + deptno);
				System.out.println(sql2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void searchData(Connection connection) {
		System.out.println("검색할 이름을 입력하세요 : ");
		ename = scanner.nextLine();
		sql = "select * from emp where ename = '" + ename + "'";
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.print(rs.getInt("empno") + "\t");
				System.out.print(rs.getString("ename") + "\t");
				System.out.print(rs.getString("job") + "\t");
				System.out.print(rs.getInt("mgr") + "\t");
				System.out.print(rs.getString("hiredate") + "\t");
				System.out.print(rs.getDouble("sal") + "\t");
				System.out.print(rs.getDouble("comm") + "\t");
				System.out.println(rs.getInt("deptno"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void insertData(Connection connection) {
		System.out.println("등록할 사원의 정보를 입력해주세요");
		System.out.print("사원번호:");
		empno = Integer.parseInt(scanner.nextLine());
		System.out.print("부서:");
		job = scanner.nextLine();
		System.out.print("사원명:");
		ename = scanner.nextLine();
		System.out.print("mgr:");
		mgr = Integer.parseInt(scanner.nextLine());
		System.out.print("입사일:");
		hiredate = scanner.nextLine();
		System.out.print("연봉:");
		sal = scanner.nextDouble();
		System.out.print("성과금:");
		comm = scanner.nextDouble();
		scanner.nextLine();
		System.out.print("부서번호:");
		deptno = Integer.parseInt(scanner.nextLine());
		String sql = "insert into emp(empno, ename, mgr, hiredate, " + "sal , comm, deptno) values (" + empno + ", '"
				+ ename + "', " + mgr + ", '" + hiredate + "', " + sal + ", " + comm + ", " + deptno + ")";
		try {
			stmt = connection.createStatement();
			int result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(sql);
	}

	private void updateData(Connection connection) {
		System.out.println("수정할 사원 번호를 입력하세요");
		empno = Integer.parseInt(scanner.nextLine());
		try {
			stmt = connection.createStatement();
			System.out.println("변경할 정보를 입력하세요");
			System.out.print("사원명: ");
			ename = scanner.nextLine();
			System.out.print("부서: ");
			job = scanner.nextLine();
			System.out.print("mgr:");
			mgr = Integer.parseInt(scanner.nextLine());
			System.out.print("연봉:");
			sal = scanner.nextDouble();
			System.out.print("성과금:");
			comm = scanner.nextDouble();
			scanner.nextLine();
			System.out.print("부서번호:");
			deptno = Integer.parseInt(scanner.nextLine());
			sql = "update emp set ename = '" + ename + "', job = '" + job + "', mgr = " + mgr + ", sal = " + sal
					+ ", comm = " + comm + ", deptno = " + deptno + " where empno = " + empno;
			int result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void deleteData(Connection connection) {
		System.out.println("삭제할 사번을 입력하세요 : ");
		empno = Integer.parseInt(scanner.nextLine());
		try {
			stmt = connection.createStatement();
			sql = "delete from emp where empno = " + empno;
			int result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// https://github.com/havanaoh/javapractice/blob/master/Practice/src/testEmp/EmpCLIEx.java
	// view = 전체검색 / search = 이름검색 / insert = 삽입 / update = 수정 / delete = 삭제
	// 숫자 입력으로 메뉴선택
	// 1번 전체 사원 검색
	// 2번 이름으로 사원 검색
	// 3번 신입사원 등록
	// 4번 사원 정보 수정시 사원 번호 입력 후 사원 번호, 입사일 제외 수정 가능
	// (사번과 입사일은 바뀔일이 없기에 제외함, 동명인이 있을 수 있어 이름보단 사번을 기준으로 둠)
	// 5번 퇴사 사원 정보 삭제

}
