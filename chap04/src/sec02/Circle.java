package sec02;

public class Circle {
	int radius; // 원의 반지름 필드
	String name; // 원의 이름을 필드

	public double getArea() { // 멤버 메소드
	return 3.14*radius*radius;
	}
	
	
	public Circle(int radius) {
		this(radius, "어떤 원");
	}


	public Circle(int radius, String name) {
		this.radius = radius;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", name=" + name + "]";
	}


	public static void main(String[] args) {
		Circle pizza = new Circle(10); // Circle 객체 생성
		double area = pizza.getArea(); // 피자의 면적 알아내기
		System.out.println(pizza.name + "의 면적은 " + area);
		
		Circle donut = new Circle(2, "자바도넛"); // Circle 객체 생성
		area = donut.getArea(); // 도넛의 면적 알아내기
		System.out.println(donut.name + "의 면적은 " + area);
	
	
	
	
	
	
	
	
	
	
	}
}
