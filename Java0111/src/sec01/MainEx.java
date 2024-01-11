package sec01;

public class MainEx {

	public static void main(String[] args) {
		if(args.length !=2) {
			System.out.println("값의 수가 부족합니다.");
			System.out.println("프로그램 종료");
			System.exit(0); // 0이 일반적으로 정상 종료를 뜻함
		}
		String str = args[0];
		System.out.println(str);

	}

}
