package sec01;

public class Passing1 {
	
	// 지역변수는 그 블럭에서만 생존한다.
	public static int method1(int y) { // 함수, 메소드
		// y도 지역변수 (단, 호출한 곳에서 값을 넘겨줘야 한다.)
		y += 1;
		return y; // 리턴 / 보이드는 return 안해도됨
	}
	
	public static void main(String[] args) {
		int x = 100;
		x = method1(x); // 호출 이름으로 실행 시킨다
		
		System.out.println("x값 : " + x);
		
		
		
		
		
	}
}
