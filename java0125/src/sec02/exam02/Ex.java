package sec02.exam02;

class Anyclass{
	void anyMethod() throws Exception {	}
	void method() {
		try {
			this.anyMethod();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
public class Ex {

	public static void main(String[] args) {
		Anyclass ac = new Anyclass();
	}

}
