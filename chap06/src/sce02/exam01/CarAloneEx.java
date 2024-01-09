package sce02.exam01;

public class CarAloneEx {

	public static void main(String[] args) {
		
		CarAlone myCar = new CarAlone();
		
		System.out.println("제작회사 : " + myCar.company);
		System.out.println("모델명 : " + myCar.model);
		System.out.println("색상 : " + myCar.color);
		System.out.println("최고속도 : " + myCar.maxSpeed);
		System.out.println("헌재속도 : " + myCar.speed);
		
		myCar.speed = 60;
		System.out.println("수정된 속도:" + myCar.speed);
		
		
	}

}
