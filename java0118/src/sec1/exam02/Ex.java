package sec1.exam02;


public class Ex {

	public static void main(String[] args) {
		RemoteControl rc = new Audio();
		rc.turnOn();
		System.out.println(rc.MAX_VOLUME);
//		rc.MAX_VOLUME = 100;
//		new RemoteControl(); 이렇게 사용안됨
		
				
	}

}
