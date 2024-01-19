package proxy;

public class RealSubject implements Isubject {

	@Override
	public void action() {
		System.out.println("원래 객체 실행");
	}

	
}
