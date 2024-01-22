package page408_1;

public class Ex {
	
	public static void main(String[] args) {
		A a = new A();
		A.B b = a.new B();
		A c = new A();
		A.B d = new A().new B();
		b.field1 = 3;
		b.method1();
	}
}
