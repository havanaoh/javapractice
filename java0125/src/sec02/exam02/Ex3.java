package sec02.exam02;

class Anyclass2{
	void anyMethod() throws InterruptedException {
		throw new InterruptedException();
		}
	
	}

public class Ex3 {

	public static void main(String[] args) {
		Anyclass2 ac = new Anyclass2();
		try {
			ac.anyMethod();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
