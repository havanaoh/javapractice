package com.proj;

import java.util.Scanner;

public class Project1 {
	public static void login(boolean loginStatus, Scanner scanner,
			String memberName, String memberSSN) {
//		if (loginStatus) { // 로그인 여부 확인
//			System.out.println("이미 로그인 상태입니다.");
//			continue;
//		}
		
		System.out.print("아이디:");  //출력문
		String name = scanner.nextLine(); // name 변수의 값 입력
		System.out.print("패스워드:");
		String strPassword = scanner.nextLine();//패스워드입력

		if (name.equals(memberName)) {
			if (strPassword.equals(memberSSN)) {
				System.out.println("로그인 성공");
				loginStatus = true;
				
			} else {
				System.out.println("로그인 실패:패스워드가 틀림");
			}
		} else {
			System.out.println("로그인 실패:아이디 존재하지 않음");
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
				
		String memberName = "admin"; // 회원 이름
		String memberSSN = "1111";  // 회원 생년월일 (패스워드로 사용)
		String memberTel = "010-1234-1234";  
		
		boolean loginStatus = false; // 로그인 여부
		boolean membershipStatus = false; // 회원가입 여부 
		
		int balance = 0; // 은행 정보
		
		
		boolean run = true;
		boolean run2 = false;
		
		AAA: while (run) {
			System.out.println("-------------------------------------");
			System.out.println("1.로그인 | 2.회원가입 | 3.예금/출금 | 4.종료");
			System.out.println("-------------------------------------");
			System.out.print("선택> ");
			int menuNum = Integer.parseInt(scanner.nextLine());
			switch (menuNum) {
			case 1:
				if (loginStatus) { // 로그인 여부 확인
					System.out.println("이미 로그인 상태입니다.");
					continue;
				}
				
				System.out.print("아이디:");  //출력문
				String name = scanner.nextLine(); // name 변수의 값 입력
				System.out.print("패스워드:");
				String strPassword = scanner.nextLine();//패스워드입력
				// int password = Integer.parseInt(strPassword); // stpassword값을 정수로 변환
				if (name.equals(memberName)) {
					if (strPassword.equals(memberSSN)) {
						System.out.println("로그인 성공");
						loginStatus = true;
						
					} else {
						System.out.println("로그인 실패:패스워드가 틀림");
					}
				} else {
					System.out.println("로그인 실패:아이디 존재하지 않음");
				}
				break;
			case 2:
				if (membershipStatus) { // 회원 가입 여부 확인
					System.out.println("이미 회원 가입된 상태입니다.");
					System.out.println("회원 정보 : " + memberName);
					do {
						System.out.println("다시 회원 가입 하시겠습니까? y/n");
						String answer = scanner.nextLine();
						if(answer.equals("n") || answer.equals("N")){
							run = true;
							continue AAA;
						} else if (answer.equals("y") || answer.equals("Y")) {
							break;
							// y,n 이외의 문자가 들어갈 경우 계속 진행하기 위해 do while 
						}
					}while(true);
					
				}
				
				// 회원 가입
				System.out.println("회원 가입");
				System.out.println("[필수 정보 입력]"); 
				System.out.print("1. 이름: ");
				memberName = scanner.nextLine(); 
				System.out.print("2. 주민번호 앞 6자리: ");
				memberSSN = scanner.nextLine(); 
				System.out.print("3. 전화번호: "); 
				memberTel = scanner.nextLine();
				System.out.println();
				System.out.println("[입력된 내용]");
				System.out.println("1. 이름: " + memberName);
				System.out.println("2. 주민번호 앞 6자리: " + memberSSN); 
				System.out.println("3. 전화번호: " + memberTel);
				membershipStatus = true;
				
				break;
			case 3:
				if(loginStatus) {
					run2 = true;
				} else {
					System.out.println("로그인 필요");
				}
				
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
						balance += Integer.parseInt(scanner.nextLine());
						break;
					case 2:
						System.out.print("출금액> ");
						balance -= Integer.parseInt(scanner.nextLine());
						break;
					case 3:
						System.out.print("잔고> ");
						System.out.println(balance);
						break;
					case 4:
						run2 = false;
						break;
					}
					System.out.println();
				}
				System.out.println("프로그램 종료");
				break;
			case 4:
				run = false;
				break;
			}
		}
		System.out.println("프로그램 종료");
		scanner.close();
	}
}
