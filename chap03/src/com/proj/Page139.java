package com.proj;

import java.util.Scanner;

public class Page139 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int score = scan.nextInt();
		int grade = score/10;
		
		switch (grade) {
		case 9 :
			System.out.println("A등급 입니다");
			break;
		case 8 : 
			System.out.println("B등급 입니다");
			break;
		case 7 :
			System.out.println("C등급 입니다");
			break;
		default : 
			System.out.println("D등급 입니다");
			break;
		}
			
		
	
	
	
	
	
	
	}
		
}		
		
	

