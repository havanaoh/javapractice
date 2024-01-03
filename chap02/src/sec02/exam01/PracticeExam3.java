package sec02.exam01;

import java.util.Scanner;

public class PracticeExam3 {
	public static void main (String[] args) {
		// p.130 / 11
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.print("아이디:");
			String name = scanner.nextLine();
		
		
			if (name.equals("java")) {
	            System.out.print("패스워드:");
	            String strPassword = scanner.nextLine();
	            int password = Integer.parseInt(strPassword);
	
	            if (password == 12345) {
	                System.out.println("로그인 성공");
	                break;
	            } else {
	                System.out.println("로그인 실패: 패스워드가 틀림");
	            }
	        } else {
	            System.out.println("로그인 실패: 아이디 존재하지 않음");
	        }
		}		
	}

}
	
	
	
	