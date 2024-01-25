package sec02.exam04;

public class Anonymuos {
	int field;
	
	public void method(int arg1, int arg2) {
		int var1 = 0;
		int var2 = 0;
		
		field = 10;
		Cal cal = new Cal() {

			@Override
			public int sum() {
				int rs = field + arg1 + arg2 + var1 + var2;
				return rs;
			}
			
		};
		int x = cal.sum();
		System.out.println(cal.sum());
	}
	public static void main(String[] ar) {
		Anonymuos anony = new Anonymuos();
		anony.method(0, 0);
		
		
	}
	
	
}
