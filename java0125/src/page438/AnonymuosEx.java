package page438;

public class AnonymuosEx {

	public static void main(String[] args) {
		Anonymuos anony = new Anonymuos();
		anony.field.start();
		anony.method1();
		anony.method2(new Worker() {

			@Override
			public void start() {
				System.out.println("test를 합니다");
			}
			
		}
				);
		
	}

}
