package sec01.exam01;

class MyClass{
	void method() {}
	}

public class NPEex {

	public static void main(String[] args) {
		MyClass mc = null; 
		System.out.println(mc); // 객체생성이 안돼서 주소가 없어서 출력안됨 
		mc.method();
		String data = null;
//		System.out.println(data); // null 출력
//		System.out.println(data.toString());
		// 널포인트이셉션
		
	}

}
