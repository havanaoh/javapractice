package com;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Project extends JFrame{
	JLabel lb1 = new JLabel("할일 목록");
	JTextArea ta1 = new JTextArea(15,30);
	public Project() {
		Container con = this.getContentPane();
		con.setLayout(null);
		this.setVisible(true);
		this.setSize(500,800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocation(500, 100);
		this.setTitle("To Do List");
		
		con.add(lb1);
		lb1.setLocation(5, 380);
		lb1.setSize(30, 30);
		con.add(ta1);
		ta1.setLocation(10, 10);
		ta1.setSize(30, 30);
		
		
		
	}
	public static void main(String[] args) {
		new Project();
	}
}
