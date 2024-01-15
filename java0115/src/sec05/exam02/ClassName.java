package sec05.exam02;

public class ClassName {
	int field1;
	void method() {}
	static int field2; // 사용(실행) 가능
	static void method2() {} // 사용(실행) 가능
	
	static void method3() { // 사용(실행) 가능
//		field1 = 10;// 즉시 사용 불가능 (객체를 생성해줘야함) 힙영역에 주소가 없어서 넣어줄수없음
		ClassName field1 = new ClassName();
		field2 = 10; // 사용(실행) 가능
	}
	
	void method4(){
		this.field1 = 10;
		ClassName.field2 = 10;
	}

}
