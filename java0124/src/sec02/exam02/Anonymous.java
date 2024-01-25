package sec02.exam02;

public class Anonymous {
	RemoteControl field = new RemoteControl() {
		
		@Override
		public void turnOn() {
			System.out.println("tv on");
		}
		@Override
		public void turnOff() {
			System.out.println("tv off");
		}
	};
	
	void method1() {
		RemoteControl localVar = new RemoteControl() {
			@Override
			public void turnOn() {
				System.out.println("Audio ON");				
			}			
			@Override
			public void turnOff() {
				System.out.println("Audio Off");			
			}
		};
		localVar.turnOn();
	}
	void method2(RemoteControl rc) {
		rc.turnOn();
	}
}
 