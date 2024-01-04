package sec02.exam01;

import java.util.Scanner;

public class ProjectPractice {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		boolean run = true;
		while(run) {
			System.out.println("================================");
			System.out.println("1. 로그인 | 2. 회원가입 | 3. 예금/출금 | 4. 종료");
			System.out.println("================================");
			System.out.println("선택");
			int menuNum = Integer.parseInt(scanner.nextLine());
			switch (menuNum){
			case 1 : // 로그인 처리
				System.out.println("로그인");
				
				System.out.print("이름:"); // 입력창 출력
				String name = scanner.nextLine(); // 이름 입력
				
				System.out.print("패스워드(주민번호 앞 6자리):"); // pw창 출력 
				String birth = scanner.nextLine(); // pw 입력
								
				if(name.equals(name)) { // 이름 일치
					if(birth.equals(birth)) { // 비밀번호 일치
						System.out.println("로그인 성공");
						run = false; // 성공적인 로그인 후 루프 종료
					}else { // 비밀번호 불일치
						System.out.println("로그인 실패:패스워드가 틀림");
					}
				} else { // 이름 불일치
					System.out.println("로그인 실패 : 아이디 존재하지 않음");
			}
			case 2: // 회원 가입
				System.out.println("회원 가입");
				
				System.out.println("[필수 정보 입력]");
		 
				System.out.print("1. 이름:");
				String name1 = scanner.nextLine();
				
				System.out.print("2. 주민번호 앞 6자리(비밀번호) :");
				String birth1 = scanner.nextLine();
				
				System.out.print("3. 전화번호:");
				String cell1 = scanner.nextLine();
				
				
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

	

}
