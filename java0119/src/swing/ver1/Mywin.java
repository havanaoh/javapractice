package swing.ver1;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Mywin extends JFrame {
	
	public Mywin() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con = this.getContentPane();
		this.setSize(400,300);
		this.setLocation(700,400);
		this.setVisible(true);
		this.setTitle("자바 스윙");
	}
	
	public static void main(String[] args) {
		new Mywin();
		

	}

}
