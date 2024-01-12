package com.project;

import java.util.Scanner;

public class Project1 {
	static Scanner scanner = new Scanner(System.in); // static 필드 
	
	public static void disp1() {
		System.out.println("-------------------------------------");
		System.out.println("1.로그인 | 2.회원가입 | 3.예금/출금 | 4.종료");
		System.out.println("-------------------------------------");
	}
	
	public static void disp2() {
		System.out.println("-------------------------------------");
		System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.상위메뉴");
		System.out.println("-------------------------------------");
	}

	public static void menu2(Session session){
//		boolean run = true;
		while (session.isRun2()/* Run2가 false 인상태인가? */) {
			// setRun2으로 줬어야되는게 아닌가? 
			// -> MenuState.DEPOSIT로 Session class에서 정해줌
			disp2();
			System.out.print("선택> ");
			int menuNum = Integer.parseInt(scanner.nextLine());
			switch (menuNum) {
			case 1:
				// 예금 입금
				System.out.println("1.예금");
				break;
			case 2:
				// 예금 출금
				System.out.println("2.출금");
				break;
			case 3:
				// 잔고 확인
				System.out.println("3.잔고 확인");
				break;
			case 4:
//				session.setRun2(false);
				session.setMenuState(MenuState.DEPOSIT_EXIT);
				System.out.println("상위 메뉴로");
				break;
			}		
		}
	}
	
	public static void menu1(Session session){
//		boolean run = true;
		while (session.isRun()/*Run이 false 인가? / run 대신 매개변수로 받음*/) {
			disp1();
			System.out.print("선택> ");
			int menuNum = Integer.parseInt(scanner.nextLine());
			switch (menuNum) {
			case 1:
				// 로그인 처리
				System.out.println("로그인 처리");
				break;
			case 2:
				// 회원 가입
				System.out.println("회원 가입");
				break;
			case 3:
				// 예금 출금
				System.out.println("예금 출금");
				if(session.getLoginInfo() != null) {// 로그인 성공 후
					session.setMenuState(MenuState.DEPOSIT);
					menu2(session);	
				}
				break;
			case 4:
//				session.setRun(false); = 
				session.setMenuState(MenuState.TOP_EXIT);
				System.out.println("프로그램 종료");
				break;
			}		
		}
	}
	
	public static void main(String[] args) {
		LoginInfo loginInfo = new LoginInfo("id", "pass"); 
		Session session = new Session(true, false, loginInfo);
		menu1(session);
		
	}
}
