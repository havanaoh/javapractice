package sec1.exam02;

public interface RemoteControl {
	public static final int MAX_VOLUME = 10; // 상수
	int MIN_VOLUME = 0;
	int x = 100; // 상수 = 변하지 않는값
	
	public abstract void turnOn(); // 추상 메소드랑
	void turnOff();
	
}
