package swingRe;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Mine extends JFrame{
	JLabel lb1 = new JLabel();
	JLabel lb2 = new JLabel();
	
	JButton bt1 = new JButton();
	JButton bt2 = new JButton();
	
	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	
	public Mine(){
	Container con = this.getContentPane();
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setSize(800, 800);
	this.setTitle("프로젝트");
	this.setLocation(10, 10);
	
	}
	public static void main(String[] args) {
		new Mine();
	}

}
