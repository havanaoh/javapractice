package sec02.exam03;



public class VehicleEx {

	public static void main(String[] args) {
//		String str = "테스트";
//		String str1 = "";
//		for(int i=0; i<100; i++) {
//			str1 += str;
//		}
//		System.out.println(str1);
//		List<Acc> list = new ArrayList();
//		list.add(123);
//		list.add("문자열");
//		list.add(3.14);
//		list.add(new Acc());
//		
//		for(Object obj : list) {
//			Acc acc = (Acc)obj;
//			String str = obj;
//			System.out.println(obj);
//		}
		Vehicle vehicle = new Bus();
		vehicle.run();
		if(vehicle instanceof Bus) {
			System.out.println("가능");
		}
		
//		vehicle.chekFare();  vehicle 인터페이스에는 checkFare가 없음
		
		Bus bus = (Bus) vehicle;
		
		bus.run();
		bus.checkFare();
		
		
	}
	

}
