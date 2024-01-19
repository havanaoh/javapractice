package swing.ver6;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Mywin extends JFrame {
	JLabel lb1 = new JLabel("이름 : ");
	JTextField jf1 = new JTextField(5);
	JButton bt1 = new JButton("버튼1");

	JLabel lb2 = new JLabel("이름? : ");
	JTextField jf2 = new JTextField(5);
	JButton bt2 = new JButton("종료!");
	
	JLabel lbState = new JLabel("메세지를 보여 줍니다.");

	public Mywin() {
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		Container con = this.getContentPane();
		con.setLayout(new FlowLayout());
		con.add(lbState);
		
		con.add(lb1);
		con.add(jf1);
		con.add(bt1);

		con.add(lb2);
		con.add(jf2);
		con.add(bt2);

		this.setSize(400, 300);
		this.setLocation(700, 400);
		this.setVisible(true);
		this.setTitle("자바 스윙");

		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼1");
				lbState.setText("버튼 1을 클릭했습니다");
			}
		});
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmExit();
			
			}
		});
		
		// 익명객체는 임플리먼트 안쓰고 쓸수있는 원리
		
		JOptionPane.showMessageDialog(this, "파일 읽었습니다.", "파일 실행",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public void confirmExit() {
		int answer = JOptionPane.showConfirmDialog(this, "종료하시겠습니까?", "종료 확인", JOptionPane.YES_NO_OPTION);
		if (answer == JOptionPane.YES_OPTION) { // 사용자가 yes 를 눌렀을경우
			System.out.println("프로그램을 종료합니다.");
			//파일로 객체를 보내는 일 처리
			System.exit(0);
		} else {// 사용자가 Yes이외의 갑을 눌렀을 경우
			System.out.println("종료를 취소합니다.");
			lbState.setText("종료를 취소합니다.");
		}
	}

	public static void main(String[] args) {
		new Mywin();
	}

}
