package sec02.exam01;

import java.util.Scanner;

public class FirstweekProject {
	
	public static void login(String name, String birth) {
		Scanner scanner = new Scanner(System.in);
		
		boolean run = true;
		while (run) {
		System.out.print("이름:");
		String name1 = scanner.nextLine();
		
		System.out.print("패스워드(주민번호 앞 6자리):");
		String birth1 = scanner.nextLine();
						
		if(name1.equals(name1)) {
			if(birth1.equals(birth1)) {
				System.out.println("로그인 성공");
				run = false; // 성공적인 로그인 후 루프 종료
			}else {
				System.out.println("로그인 실패:패스워드가 틀림");
			}
		} else {
			System.out.println("로그인 실패 : 아이디 존재하지 않음");
		}
		}
	}
		
		public static void bank() {
			Scanner scanner = new Scanner(System.in);
			boolean run = true;
			int balance = 0;
			while (run) {
				 System.out.println("-------------------------------------");
				 System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
				 System.out.println("-------------------------------------");
				 System.out.print("선택> ");
				 int menuNum = Integer.parseInt(scanner.nextLine());
				 switch (menuNum) {
				 case 1:
				 System.out.print("예금액> ");
				 int plus = Integer.parseInt(scanner.nextLine());
				 balance += plus;
				 System.out.println("현재 잔고 : " + balance);
				 break;
				 case 2:
				 System.out.print("출금액> ");
				 int minus = Integer.parseInt(scanner.nextLine()); 
				 balance -= minus;
				 System.out.println("현재 잔고 : " + balance);
				 break;
				 case 3:
				 System.out.print("잔고> ");
				 System.out.println(balance);
				 break;
				 case 4:
				 run = false;
				 System.exit(4);
				 System.out.println("프로그램 종료");
				 break;
				 }
				 
			}
			 	
		}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("[회원 가입]" );
		
		System.out.print("1. 이름:");
		String name = scanner.nextLine();
		
		System.out.print("2. 주민번호 앞 6자리:");
		String birth = scanner.nextLine();
		
		System.out.print("3. 전화번호:");
		String cell = scanner.nextLine();
				
		login(name, birth);
		boolean run = true;
		while (true) {
			bank();
		}
	

	}

}
