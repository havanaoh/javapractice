package sec01.verify.exam03;

public class NestedClassEx {
	public static void main(String[] args) {
		Car myCar = new Car();
		Car.Tire tire = myCar.new Tire();
		Car.Engine en = new Car.Engine();
		
	}
}
