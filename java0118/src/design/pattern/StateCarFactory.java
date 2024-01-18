package design.pattern;

// 국산차 생산 공장
public class StateCarFactory extends CarFactory {

	@Override
	public TireProduct createTire() {
		return new StateTireProduct();
	}

	@Override
	public DoorProduct createDoor() {
		return new StateDoorProduct();
	}

}
