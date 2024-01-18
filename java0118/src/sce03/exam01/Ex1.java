package sce03.exam01;

public class Ex1 {

	public static void main(String[] args) {
//		Phone phone = new Phone(); 안됨
		Phone phone = new SmartPhone2(0, 0);
		System.out.println(phone.x);
//		Phone phone1 = new SmartPhone();
//		SmartPhone sp = (SmartPhone) phone1;
		if(phone instanceof SmartPhone) {
			SmartPhone sp = (SmartPhone) phone;
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
				
				
	
		
	}

}
