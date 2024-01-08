package sec01.exam01;

public class StaticEx {
	
	static int y; // 정적 필드
	
	public static void main(String[] args) {
		System.out.println(y);
		y = 300;
		int x = 100; // 지역변수
		m1(100);
		System.out.println(x);
	}
	
	public static void m1(int x){ // 매개 변수 (일종의 지역변수)
		System.out.println(y);
		x = 200;
		System.out.println(x);
	}

}
