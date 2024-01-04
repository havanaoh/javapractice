package sec02.exam01;

import java.util.Scanner;

public class PracticeExam {
	public static void main (String[] args) {
//		p.98 1번
		String name = "감자바";
		int age = 25;
		String tel1 = "010", tel2 = "123", tel3 = "4567";
		
		System.out.println("이름 : " + name);
		System.out.print("나이 : " + age + "\n");
		System.out.printf("전화 : %1$s-%2$s-%3$s\n", tel1, tel2, tel3);
		
		//p.98 2번
		
//		Scanner scanner = new Scanner(System.in);
//		
//		System.out.println("첫번째 수 : ");
//		String strNum1 = scanner.nextLine();
//		
//		System.out.println("두번째 수 : ");
//		String strNum2 = scanner.nextLine();
//				
//		int num1 = Integer.parseInt(strNum1);
//		int num2 = Integer.parseInt(strNum2);
//		int result = num1 + num2;
//		System.out.println("덧셈 결과 : " + result);
		
		
		// p.99 3 (회원가입)
		
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("[필수 입력 정보]" );
//		
//		System.out.print("1. 이름:");
//		String name = scanner.nextLine();
//		
//		System.out.print("2. 주민번호 앞 6자리:");
//		String birth = scanner.nextLine();
//		
//		System.out.print("3. 전화번호:");
//		String cell = scanner.nextLine();
//		
//		
//		System.out.println("[입력한 내용]");
//		System.out.println(name);
//		System.out.println(birth);
//		System.out.println(cell);
		
		// p.130 / 11 (로그인)
		
//		Scanner scanner = new Scanner(System.in);
//		
//		System.out.print("아이디:");
//		String name = scanner.nextLine();
//		
//		System.out.print("패스워드:");
//		String strPassword = scanner.nextLine();
//		
//		int password = Integer.parseInt(strPassword);
//		
//		if(name.equals("java")) {
//			if(password == 12345) {
//				System.out.println("로그인 성공");
//			}else {
//				System.out.println("로그인 실패:패스워드가 틀림");
//			}
//		} else {
//			System.out.println("로그인 실패 : 아이디 존재하지 않음");
//		}
		
		// p.160 / 7 
		
		boolean run = true;
		int balance = 0;
		Scanner scanner = new Scanner(System.in);
		while(run) {
			System.out.println("----------------");
			System.out.println("1.예금 : 2.출금 : 3.잔고 : 4.종료");
			System.out.println("----------------");
			System.out.print("선택> ");
		
			int num = Integer.parseInt(scanner.nextLine());
			switch(num) {
			case 1:
				System.out.println("예금액> ");
				balance += Integer.parseInt(scanner.nextLine());
				break; 
			case 2:
				System.out.println("출금액> ");
				balance -= Integer.parseInt(scanner.nextLine());
				
				
			}
				
		}
		System.out.println("프로그램 종료");
	
	
	}
}
