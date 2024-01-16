package sec02.exam01;

class A{}

class B extends A{}
class C extends A{}

class D extends B{}
class E extends C{}

public class PromoEx {

	public static void main(String[] args) {
		Object obj = new PromoEx(); // 모든 클래스 다 가능
		B b = new B();
		C c = new C();
		D d = new D();
		E e = new E();
		
		A a1 = b;
		A a2 = c;
		A a3 = d;
		A a4 = e;
		
		B b1 = d;
		C c1 = e; // 부모로 변수선언, 자식으로 객체생성
		
//		B b3 = e;
//		C c2 = d;
		

	}

}
