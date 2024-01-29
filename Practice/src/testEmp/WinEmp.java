package testEmp;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class WinEmp extends JFrame {
	
	JLabel lb1 = new JLabel("사원번호 : ");
	JLabel lb2 = new JLabel("사원명 : ");
	JLabel lb3 = new JLabel("부서 : ");
	JLabel lb4 = new JLabel("mgr : ");
	JLabel lb5 = new JLabel("입사일 : ");
	JLabel lb6 = new JLabel("연봉 : ");
	JLabel lb7 = new JLabel("성과금 : ");
	JLabel lb8 = new JLabel("부서번호 : ");
	
	JTextField tfempno = new JTextField(5);
	JTextField tfename = new JTextField(5);
	JTextField tfjob = new JTextField(5);
	JTextField tfmgr = new JTextField(5);
	JTextField tfhiredate = new JTextField(5);
	JTextField tfsal = new JTextField(5);
	JTextField tfcomm = new JTextField(5);
	JTextField tfdeptno = new JTextField(5);
	
	JButton bt1 = new JButton("전체 내용");
	JButton bt2 = new JButton("입력");
	JButton bt3 = new JButton("이름 검색");
	JButton bt4 = new JButton("수정");
	JButton bt5 = new JButton("삭제");
	JTextArea ta = new JTextArea(20,80);
	
	Connection conn;
	Statement stmt;
	
	public WinEmp() {
		String url = "jdbc:mysql://localhost:3306/firm";
		String id = "root";
		String pass = "mysql";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		JPanel jp1 = new JPanel(new FlowLayout());
		
		jp1.add(bt1);jp1.add(bt2);jp1.add(bt3);jp1.add(bt4);jp1.add(bt5);
		
		con.add(jp1, BorderLayout.SOUTH);
		JScrollPane scroll = new JScrollPane(ta);
		JPanel jp2 = new JPanel(new FlowLayout());
		con.add(jp2, BorderLayout.CENTER);
		jp2.add(scroll);
		
		JPanel jp3 = new JPanel(new FlowLayout());
		con.add(jp3, BorderLayout.NORTH);
		jp3.add(lb1); jp3.add(tfempno);
		jp3.add(lb2); jp3.add(tfename);
		jp3.add(lb3); jp3.add(tfjob);
		jp3.add(lb4); jp3.add(tfmgr);
		jp3.add(lb5); jp3.add(tfhiredate);
		jp3.add(lb6); jp3.add(tfsal);
		jp3.add(lb7); jp3.add(tfcomm);
		jp3.add(lb8); jp3.add(tfdeptno);
		
		this.setTitle("Emp system");
		this.setLocation(50,50);
		this.setSize(1080,500);
		this.setVisible(true);
		
		bt1.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				select();
				clearTextField();
			}
		});
		bt2.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				insert();
				clearTextField();
				select();
			}
		});
		bt3.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {			
				search();
			}
		});
		bt4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				update();
				search();
			}
		});
		bt5.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				delete();
				select();
				clearTextField();
			}
		});
	}
	
	private void clearTextField() {
		tfjob.setText(""); tfename.setText(""); tfcomm.setText("");
		tfmgr.setText(""); tfhiredate.setText(""); tfempno.setText(""); 
		tfsal.setText(""); tfdeptno.setText("");
	}
	
	public void select() {
		String sql = "select empno, ename, job, mgr"
				+ ", hiredate, sal, comm, deptno from emp";
		try {
			ResultSet rs = stmt.executeQuery(sql);
			ta.setText("");
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				String hiredate = rs.getString("hiredate");
				double sal = rs.getDouble("sal");
				double comm = rs.getDouble("comm");
				int deptno = rs.getInt("deptno");
				String str = empno+"\t"+ename+"\t"+job+"\t"+mgr+"\t"
				+hiredate+"\t"+sal+"\t"+comm+"\t"+deptno+"\n";
				ta.append(str);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insert() {
		String sql = "insert into emp(empno, ename, job, mgr, hiredate,"
				+ "sal, comm, deptno) values (" +tfempno.getText()+", '"
				+tfename.getText()+"', '"+tfjob.getText()+"', "+tfmgr.getText()
				+", '"+tfhiredate.getText()+"', "+tfsal.getText()
				+", "+tfcomm.getText()+", "+tfdeptno.getText()+")";
		try {
			int result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update() {
		String sql = "update emp set ename = '" + tfename.getText() 
		+"', job = '" + tfjob.getText() + "', mgr = " 
		+ Integer.parseInt(tfmgr.getText())+", sal = "
		+ Double.parseDouble(tfsal.getText())+ ", comm = "
		+ Double.parseDouble(tfcomm.getText())+", deptno = "
		+ Integer.parseInt(tfdeptno.getText())+" where empno = "
		+ Integer.parseInt(tfempno.getText()); 
		try {
			stmt = conn.createStatement();
			int rs = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void search() {
		String sql = "select * from emp where ename = '"+tfename.getText()
		+"'";
		try {
			ResultSet rs = stmt.executeQuery(sql);
			ta.setText("");
			if(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				String hiredate = rs.getString("hiredate");
				double sal = rs.getDouble("sal");
				double comm = rs.getDouble("comm");
				int deptno = rs.getInt("deptno");
				String str = empno+"\t"+ename+"\t"+job+"\t"+mgr+"\t"
				+hiredate+"\t"+sal+"\t"+comm+"\t"+deptno+"\n";
				ta.append(str);
				tfempno.setText(String.valueOf(empno));
				tfename.setText(ename);
				tfjob.setText(job);
				tfmgr.setText(String.valueOf(mgr));
				tfhiredate.setText(hiredate);
				tfsal.setText(String.valueOf(sal));
				tfcomm.setText(String.valueOf(comm));
				tfdeptno.setText(String.valueOf(deptno));
				}else {
					tfempno.setText("");
					tfename.setText("");
					tfjob.setText("");
					tfmgr.setText("");
					tfhiredate.setText("");
					tfsal.setText("");
					tfcomm.setText("");
					tfjob.setText("");
					tfdeptno.setText("");
					ta.append("해당 자료 없습니다.");
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete() {
		int empno = Integer.parseInt(tfempno.getText());
		try {
			stmt = conn.createStatement();
			String sql = "delete from emp where empno = " + empno;
			int rs = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void main(String[] args) {
		new WinEmp();
	}

}
