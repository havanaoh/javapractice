package swing;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Window extends JFrame{
	public Window() {
		Container con = this.getContentPane();
		con.setLayout(null);
		
		this.setLocation(10, 10);
		this.setTitle("스윙 연습");
		this.setVisible(true); // 윈도우 프레임을 보이게
		this.setSize(1080, 960); // 크기 설정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel jl1 = new JLabel("이름");
		con.add(jl1);
		jl1.setLocation(70, 20);
		jl1.setSize(30,30);
		
		JTextField jt1 = new JTextField();
		con.add(jt1);
		jt1.setLocation(100, 20);
		jt1.setSize(100, 30);
		
		JLabel jl2 = new JLabel("ID");
		con.add(jl2);
		jl2.setLocation(270, 20);
		jl2.setSize(30,30);
		
		JTextField jt2 = new JTextField();
		con.add(jt2);
		jt2.setLocation(300, 20);
		jt2.setSize(100, 30);
		
		JLabel jl3 = new JLabel("PW");
		con.add(jl3);
		jl3.setLocation(470, 20);
		jl3.setSize(30,30);
		
		JTextField jt3 = new JTextField();
		con.add(jt3);
		jt3.setLocation(500, 20);
		jt3.setSize(100, 30);
		
		
		JLabel jl4 = new JLabel("Birth");
		con.add(jl4);
		jl4.setLocation(670, 20);
		jl4.setSize(30,30);
		
		JTextField jt4 = new JTextField();
		con.add(jt4);
		jt4.setLocation(700, 20);
		jt4.setSize(100, 30);
		
		JLabel jl5 = new JLabel("Tel");
		con.add(jl5);
		jl5.setLocation(870, 20);
		jl5.setSize(30,30);
		
		JTextField jt5 = new JTextField();
		con.add(jt5);
		jt5.setLocation(900, 20);
		jt5.setSize(100, 30);
		
		JLabel jl6 = new JLabel("잔고");
		con.add(jl6);
		jl6.setLocation(70, 70);
		jl6.setSize(30,30);
		
		JTextField jt6 = new JTextField();
		con.add(jt6);
		jt6.setLocation(100, 70);
		jt6.setSize(100, 30);
		
		
		JButton jbl = new JButton("전체 내용");
		jbl.setLocation(100, 800);
		jbl.setSize(100, 40);
		con.add(jbl);
		
		JButton jb2 = new JButton("입력");
		jb2.setLocation(300, 800);
		jb2.setSize(100, 40);
		con.add(jb2);
		
		JButton jb3 = new JButton("조회");
		jb3.setLocation(500, 800);
		jb3.setSize(100, 40);
		con.add(jb3);
		
		JButton jb4 = new JButton("수정");
		jb4.setLocation(700, 800);
		jb4.setSize(100, 40);
		con.add(jb4);
		
		JButton jb5 = new JButton("삭제");
		jb5.setLocation(900, 800);
		jb5.setSize(100, 40);
		con.add(jb5);
		
		
		
	}

	public static void main(String[] args) {
		new Window();

	}
}
