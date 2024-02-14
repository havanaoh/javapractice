package ramda;

public class MyFuncEx {
	// 람다식은 어레이리스트에 상관있음
	public static void main(String[] args) {
		MyFunc mf, mf3;
		
		mf3 =x -> System.out.println(x);  //람다식
		mf3.method(20);
		
		mf = new MyFunc() {  // 익명 객체 생성
			
			@Override
			public void method(int x) {
				System.out.println(x);
			}
		};

		mf.method(10);
		

	}

}