package sec02.exam02;

class Anyclass3{
	void anyMethod() {
		throw new NullPointerException();
		}
	
	}

public class Ex2 {

	public static void main(String[] args) {
		Anyclass3 ac = new Anyclass3();
		try {
			ac.anyMethod();
		}catch(NullPointerException e) {
			
		}
		
		System.out.println("계속 실행 중");
	}

}
