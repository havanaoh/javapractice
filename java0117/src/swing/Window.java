package swing;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Window extends JFrame implements ActionListener
										{
	JButton jb1 = new JButton("전체 내용");
	JButton jb2 = new JButton("입력");
	JButton jb3 = new JButton("조회");
	JButton jb4 = new JButton("수정");
	JButton jb5 = new JButton("삭제");
	
	
	JTextField jt1 = new JTextField();
	JTextField jt2 = new JTextField();
	JTextField jt3 = new JTextField();
	JTextField jt4 = new JTextField();
	JTextField jt5 = new JTextField();
	JTextField jt6 = new JTextField();
	
	List<Member> list = new ArrayList<>();
	
	public Window() {
		jb1.addActionListener(this);
		jb2.addActionListener(this);
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
		jl1.setSize(30, 30);

		JLabel jl2 = new JLabel("ID");
		con.add(jl2);
		jl2.setLocation(270, 20);
		jl2.setSize(30, 30);

		JLabel jl3 = new JLabel("PW");
		con.add(jl3);
		jl3.setLocation(470, 20);
		jl3.setSize(30, 30);

		JLabel jl4 = new JLabel("Birth");
		con.add(jl4);
		jl4.setLocation(670, 20);
		jl4.setSize(30, 30);

		JLabel jl5 = new JLabel("Tel");
		con.add(jl5);
		jl5.setLocation(870, 20);
		jl5.setSize(30, 30);
		
		JLabel jl6 = new JLabel("잔고");
		con.add(jl6);
		jl6.setLocation(70, 70);
		jl6.setSize(30, 30);
		
		con.add(jt1);
		jt1.setLocation(100, 20);
		jt1.setSize(100, 30);

		con.add(jt2);
		jt2.setLocation(300, 20);
		jt2.setSize(100, 30);

		con.add(jt3);
		jt3.setLocation(500, 20);
		jt3.setSize(100, 30);

		con.add(jt4);
		jt4.setLocation(700, 20);
		jt4.setSize(100, 30);

		con.add(jt5);
		jt5.setLocation(900, 20);
		jt5.setSize(100, 30);

		con.add(jt6);
		jt6.setLocation(100, 70);
		jt6.setSize(100, 30);
		
		JTextArea ta = new JTextArea();
		ta.setLocation(100, 120);
		ta.setSize(900, 650);
		con.add(ta);

		jb1.setLocation(100, 800);
		jb1.setSize(100, 40);
		con.add(jb1);

		jb2.setLocation(300, 800);
		jb2.setSize(100, 40);
		con.add(jb2);

		jb3.setLocation(500, 800);
		jb3.setSize(100, 40);
		con.add(jb3);

		jb4.setLocation(700, 800);
		jb4.setSize(100, 40);
		con.add(jb4);

		jb5.setLocation(900, 800);
		jb5.setSize(100, 40);
		con.add(jb5);

	}

	public static void main(String[] args) {
		new Window();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		switch (e.getActionCommand()) {
		case "전체내용":
			System.out.println("전체내용 나오기");
			break;
		case "입력":
			System.out.println("입력 실행");
			System.out.printf("%s,%s,%s,%s,%s\n", jt1.getText(),
					jt2.getText(),jt3.getText(), 
					jt4.getText(),jt5.getText(), jt6.getText());
			int balance = Integer.parseInt(jt6.getText());
			list.add(new Member(jt1.getText(), jt2.getText(), 
					jt3.getText(), jt4.getText(),
					jt5.getText(), balance));			
			break;
		case "조회":
			System.out.println("조회 실행");
			for (Member mb : list) {
				System.out.println(mb);
			}			
			break;
		case "수정":
			System.out.println("수정 실행");
			break;
		case "삭제":
			System.out.println("삭제 실행");
			break;
		default:
			break;
		}

	}
}
