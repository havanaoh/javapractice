package page416;

public class Outter {
	String field = "Outter - field";
	void method() {
		System.out.println("Outter - method");
	}
	class Nested {
		String field = "Nested - field";
		void method() {
			System.out.println("Nested - method");
		}
		void print() {
			System.out.println(this.field); // 누구? 11라인
			System.out.println(field); // 얘는 누굴까? / 9번라인 아님?
			System.out.println(Outter.this.field);  // 누굴까?
		}
	}
}
