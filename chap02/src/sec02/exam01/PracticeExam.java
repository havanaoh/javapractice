package sec02.exam01;

import java.util.Scanner;

public class PracticeExam {
	public static void main (String[] args) {
		//p.98 1번
		String name = "감자바";
		int age = 25;
		String tel1 = "010", tel2 = "123", tel3 = "4567";
		
		System.out.println("이름 : " + name);
		System.out.print("나이 : " + age + "\n");
		System.out.printf("전화 : %1$s-%2$s-%3$s\n", tel1, tel2, tel3);
		
		//p.98 2번
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("첫번째 수 : ");
		String strNum1 = scanner.nextLine();
		
		System.out.println("두번째 수 : ");
		String strNum2 = scanner.nextLine();
				
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		int result = num1 + num2;
		System.out.println("덧셈 결과 : " + result);
		
		
		//
	
	}
}
