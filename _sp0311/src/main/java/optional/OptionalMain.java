package optional;

import java.util.Optional;

class Bbb{
	int x;
	public Bbb(int x) {
		this.x = x;
	}
	void print() {
		System.out.println("Bbb: " + x);
	}
}

class Aaa{
	void print(Bbb bb) {
		bb.print();
	}
}

public class OptionalMain {

	public static void main(String[] args) {
		Aaa aa = new Aaa();
		Bbb bb = null; // 가정 값이 예상 안됨.
//		Bbb bb = new Bbb(100);
//		aa.print(null);
		
		Optional<Bbb> bb1 = Optional.ofNullable(bb);
		System.out.println(bb1);
		aa.print(bb1.orElseGet(()->new Bbb(0)));

	}

}
