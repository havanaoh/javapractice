package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Project {
	
	public static void main(String[] agrs) {
		Scanner scanner = new Scanner(System.in);
		boolean run = true;
		List<Member> list = new ArrayList<>();
		while (run) {
			System.out.println("-------------------------------------");
			System.out.println("1.회원출력 | 2.회원등록 | 3.파일저장 | 4.파일읽기 |5.종료");
			System.out.println("-------------------------------------");
			System.out.print("선택> ");
			int menuNum = Integer.parseInt(scanner.nextLine());
			switch (menuNum) {
			case 1:
				System.out.println("회원 출력");
				for (Member member : list) {
				System.out.println(member);
				}
				break;
			case 2:
				System.out.println("회원 등록");
				System.out.print("이름:");
				String name = scanner.nextLine();
				System.out.print("ID:");
				String id = scanner.nextLine();
				System.out.print("생년월일:");
				String ssn = scanner.nextLine();
				System.out.print("비밀번호:");
				String pw = scanner.nextLine();
				System.out.print("전화번호:");
				String tel = scanner.nextLine();
				list.add(new Member(name, id, ssn, pw, tel));
				break;
			case 3:
				System.out.println("파일 저장");
				break;
			case 4:
				System.out.println("파일 읽기");
				break;
			case 5:
				System.out.println("종료");
				run = false;
				break;
			}
		}
	}


}