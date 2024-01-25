package java0124;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class Dept {
	private int deptno;
	private String dname;
	private String loc;

	public Dept(int deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

}

public class TryCatchEx2 {

	public static void main(String[] args) {
		List<Dept> list = new ArrayList<>();
		String url = "jdbc:mysql://localhost:3306/firm";
		String id = "root"; // 사용자 만들어서 바뀔수있음
		String pass = "mysql";
		Statement stmt = null;
		Connection conn = null;
		String sql = "SELECT deptno, dname, loc from dept";
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver"); // jar 파일 넣어주면됨
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement(); // 명령문
			ResultSet rs = stmt.executeQuery(sql); // 실행
			while (rs.next()) {
//				int deptno = rs.getInt(1); // 속성 번호와 관계있음
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				String str = deptno + "," + dname + "," + loc;
//				System.out.println(deptno + "," + dname + "," + loc);
				Dept dept = new Dept(deptno, dname, loc);
				list.add(dept);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list);

		for (Dept dept : list) {
			System.out.println(dept);
		}

		// list에 있는 자료를 모두 출력하세요. (향상된 반복문 사용)
		for (Dept dept : list) {
//				System.out.println(dept); // 이 라인은 삭제하고 각 컬럼별로 출력해 보세요
			System.out.println(dept.getDeptno() + "\t" + dept.getDname() + "\t" + dept.getLoc());

		}
		// 문제점? dname 컬럼만 사용하고 싶다? 지금은 불가하쥐...클래스를 만들자 !!!

	}

}
