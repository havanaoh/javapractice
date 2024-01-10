package sec05.exam01;

public class Circle {
	
	int radius;
	
	public Circle(int radius){
		this.radius = radius;
	}
	
	public void set (int radius) {
		this.radius = radius;
	}
	
	public static void main(String[] args) {
		Circle cir1 = new Circle(2);
		System.out.println(cir1.radius);
		cir1.set(4);
		System.out.println(cir1.radius);
		cir1.set(8);
		System.out.println(cir1.radius);
		
	}

}
