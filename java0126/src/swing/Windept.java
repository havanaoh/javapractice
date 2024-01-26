package swing;

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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Windept extends JFrame {
	JLabel lb1 = new JLabel("부서코드:");
	JLabel lb2 = new JLabel("부서명:");
	JLabel lb3 = new JLabel("부서위치:");

	JTextField deptno = new JTextField(5);
	JTextField dname = new JTextField(5);
	JTextField loc = new JTextField(5);
	
	JButton bt1 = new JButton("전체 내용");
	JButton bt2 = new JButton("입력");
	JButton bt3 = new JButton("이름 검색");
	JButton bt4 = new JButton("수정");
	JButton bt5 = new JButton("삭제");
	JTextArea ta = new JTextArea(10,40);
	Connection conn;
	Statement stmt;
	public Windept()  {
		String url = "jdbc:mysql://localhost:3306/firm";
		String id = "root";
		String pass = "mysql";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
		} catch (SQLException | ClassNotFoundException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con = this.getContentPane();
		con.setLayout(new BorderLayout());
		JPanel jp1 = new JPanel(new FlowLayout());
		
		jp1.add(bt1);jp1.add(bt2);jp1.add(bt3);
		jp1.add(bt4);jp1.add(bt5);
		
		con.add(jp1, BorderLayout.SOUTH);
		JScrollPane scroll = new JScrollPane(ta);
		JPanel jp2 = new JPanel(new FlowLayout());
		con.add(jp2, BorderLayout.CENTER);
		jp2.add(scroll);
		
		JPanel jp3 = new JPanel(new FlowLayout());
		con.add(jp3, BorderLayout.NORTH);
		jp3.add(lb1); jp3.add(deptno);
		jp3.add(lb2); jp3.add(dname);
		jp3.add(lb3); jp3.add(loc);
		
		this.setTitle("DEPT 관리");
		this.setLocation(500, 400);
		this.setSize(500, 400);
		this.setVisible(true);
		
		bt1.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				select();				
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
				clearTextField();
				search();
			}
		});
		bt4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				update();				
			}
		});
		bt5.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				delete();
				select();
			}
		});
	
	}
	private void clearTextField() {
		deptno.setText("");dname.setText("");loc.setText(""); 
	}
	
	public void select() {
		String sql = "select deptno, dname, loc from dept";
		try {
			ResultSet rs = stmt.executeQuery(sql);
			ta.setText("");
			while(rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				String str = String.format("%d, %s, %s\n",
						deptno, dname, loc);
				ta.append(str);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insert() {
		String sql = String.format("insert into dept values(%s, '%s',"
				+ " '%s')",	deptno.getText(),dname.getText(), 
				loc.getText());
		try {
			int rs = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void update() {
		String sql = "update dept set dname = '" +dname.getText()+
				"', loc = '"+loc.getText()+"' where deptno = "
				+deptno.getText();
		System.out.println(sql);
		try {
			int rs = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void search() {
		String sql = "select * from dept where dname = '"+dname.getText()
		+"'";
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				String str = String.format("%d, %s, %s\n",
						deptno, dname, loc);
				ta.append(str);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete() {
		String sql = "delete from dept where dname = '" + dname.getText()
		+"'";
		try {
			int rs = stmt.executeUpdate(sql);
		} catch (SQLException e) {			
			e.printStackTrace();
		} 
	}
	
	public static void main(String[] args) {
		new Windept();
	}
	
	
}