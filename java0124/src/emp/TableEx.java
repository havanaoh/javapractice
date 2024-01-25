package emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class TableEx {

	public static void main(String[] args) {
		List<Emp> list = new ArrayList<>();
		String url = "jdbc:mysql://localhost:3306/firm";
		String id = "root"; // 사용자 만들어서 바뀔수있음
		String pass = "mysql";
		Statement stmt = null;
		Connection conn = null;
		String sql = "SELECT empno, ename, job, sal from emp";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				double sal = rs.getDouble("sal");
				Emp emp = new Emp(empno, ename, job, sal);
				list.add(emp);
			}
		
		} catch (SQLException e) {
			
		}
		for (Emp emp : list) {
			System.out.println(emp.getEmpno() + "\t"+emp.getEname()+"\t"+emp.getJob()+"\t"+emp.getSal());
		}
	}

}
