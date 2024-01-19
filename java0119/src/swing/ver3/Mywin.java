package swing.ver3;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Mywin extends JFrame implements ActionListener {
	JLabel lb1 = new JLabel("이름 : ");
	JTextField jf1 = new JTextField(5);
	JButton bt1 = new JButton("버튼1");
	
	JLabel lb2 = new JLabel("이름? : ");
	JTextField jf2 = new JTextField(5);
	JButton bt2 = new JButton("버튼2");
	
	public Mywin() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con = this.getContentPane();
		con.setLayout(new FlowLayout());
		
		con.add(lb1);
		con.add(jf1);
		con.add(bt1);
		
		con.add(lb2);
		con.add(jf2);
		con.add(bt2);
		
		this.setSize(400,300);
		this.setLocation(700,400);
		this.setVisible(true);
		this.setTitle("자바 스윙");
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);		
	}
	
	public static void main(String[] args) {
		new Mywin();
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("클릭!");
		if(e.getSource()==bt1) {
			System.out.println("버튼1");
		}else if(e.getSource().equals(bt2)) {
			System.out.println("버튼2");
		}
	}

}

