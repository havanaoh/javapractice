package page415;

public class Outter {
	public void method2(int arg) {
		int localVar = 1;
		arg = 100;
		localVar = 100; 
// 		내부 클래스에는 지역변수를 쓸수없다  
//		Inner class가 스레드로 외부에서 작동할수 있기 때문에 
//		class Inner {
//			public void method() {
//				int result = arg + localVar;
//			}
		}
	}
	


