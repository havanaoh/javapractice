package sce02.exam01;

public class Car {
	
	String company; // 객체의 성격을 뜻함
	String model;
	String color;
	int maxSpeed;
	
	Car() { // 생성자는 클래스 이름과 같고 메소드임 /
		System.out.println("Car()");
		
	}
	
	Car(String str) { //오버로딩 
		company = str;
	}
	
	Car(String str, String str1) { //오버로딩 
		company = str;
		model = str1;
	}
	
	
	
	Car(String company, int maxSpeed) {
		super();
		this.company = company;
		this.maxSpeed = maxSpeed;
	}

	Car(String company, String model, String color, int maxSpeed) {
		super(); // 상속에 관련된것
		this.company = company;
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}

	@Override
	public String toString() {
		return "Car [company=" + company + ", model=" + model + ", color=" + color + ", maxSpeed=" + maxSpeed + "]";
	}
	
	

}
