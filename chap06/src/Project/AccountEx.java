package Project;

<<<<<<< HEAD
import java.util.Scanner;

public class AccountEx {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		boolean run = true;
		boolean run2 = true;
		Account acc = null;
		
		while (run) {
			System.out.println("-------------------------------------");
			System.out.println("1.로그인 | 2.회원가입 | 3.예금/출금 | 4.종료");
			System.out.println("-------------------------------------");
			System.out.print("선택> ");
			int menuNum = Integer.parseInt(scanner.nextLine());
			switch (menuNum) {
			case 1:
				// 로그인 처리
				System.out.println("로그인 처리");
				System.out.print("아이디:");
				String id = scanner.nextLine();
				System.out.print("비밀번호:");
				String pass = scanner.nextLine();
				if(id.equals(acc.name)) {
					if(pass.equals(acc.ssn)) {
					System.out.println("로그인 되었습니다.");
					}else System.out.println("비밀번호 오류입니다.");
				}else System.out.println("아이디가 존재하지 않습니다.");
				
				break;
			case 2:
				// 회원 가입
				System.out.println("회원 가입");
				System.out.println("이름: ");
				String name = scanner.nextLine();
				System.out.println("생년월일: ");
				String ssn = scanner.nextLine();
				System.out.println("전화번호: ");
				String tel = scanner.nextLine();
				acc = new Account(name, ssn, tel);
				System.out.println(acc);
				break;
			case 3:
				// 예금 출금
				System.out.println("예금 출금");
				while (run2) {
					System.out.println("-------------------------------------");
					System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
					System.out.println("-------------------------------------");
					System.out.print("선택> ");
					int menuNum2 = Integer.parseInt(scanner.nextLine());
					
					switch (menuNum2) {
					case 1:
						System.out.print("예금액> ");
						acc.balance += Integer.parseInt(scanner.nextLine());
						System.out.println("현재 잔고> " + acc.balance);
						break;
					case 2:
						System.out.print("출금액> ");
						acc.balance -= Integer.parseInt(scanner.nextLine());
						System.out.println("현재 잔고> " + acc.balance);
						break;
					case 3:
						System.out.print("잔고> ");
						System.out.println(acc.balance);					
						break;
					case 4:
						run2 = false;
						System.out.println("은행 프로그램 종료");
						break;
						}
				}
				break;
			case 4:
				run = false;
				break;
			}
		}
		System.out.println("프로그램 종료");
		}

}

