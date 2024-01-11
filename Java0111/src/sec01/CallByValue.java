package sec01;

class MyClass {
	int n;
}

public class CallByValue {
	
	public static void increase (int n, MyClass mc) {
		n = n+1;
		System.out.println("increase : " + n);
		mc.n += 1;
		System.out.println("increase : " + mc.n);
	}
	
	public static void main(String[] args) {
		int n = 100;
		MyClass mc = new MyClass();
		System.out.println(mc.n);
//		increase(n,mc);
		increase(n, new MyClass()); // 주소값이 다름
//		n = n+1;
//		System.out.println("increase : " + n);
//		mc.n += 1;
//		System.out.println("increase : " + mc.n);
		
		System.out.println(n);
		System.out.println(mc.n); // 19번 줄과 주소값이 다를까?
		
		

	}

}
