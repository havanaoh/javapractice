package sec01.exam22;

public class BoxingEx {

	public static void main(String[] args) {
		Integer num1 = new Integer(3);
		Integer num2 = new Integer(3);
		System.out.println(num1 == num2);
		System.out.println(num1.equals(num2));
		
		int x = 100;
		String str = "가나다";
		Integer obj2 = Integer.valueOf("100");
		Integer obj1 = 300;
		System.out.println(obj1);
		//언박싱
		int y = obj1.intValue();
		System.out.println(y);
		int z = x+ obj1;
		System.out.println(z);
		
		System.out.println(z==obj2);
	}

}
