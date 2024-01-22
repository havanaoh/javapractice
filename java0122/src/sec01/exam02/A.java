package sec01.exam02;

public class A {
	B field1 = new B();
	C field2 = new C();
	
//	staic B field3 = new B();
	
	// Ark 객체생성 되어야 B도 생성이 된다.
	static B field3 = new A().new B();
	static C field4 = new C();
	
	void method1() {
		B var1 = new B();
		C var2 = new C();
	}
	
	static void method2() {
//		B var1 = new B();
		C var2 = new C();
		B var1 = new A().new B();
	}
	class B{}
	static class C{}
}

