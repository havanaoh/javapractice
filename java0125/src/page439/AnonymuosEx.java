package page439;

public class AnonymuosEx {

	public static void main(String[] args) {
		Anonymuos anony = new Anonymuos();
		anony.field.run();
		anony.method1();
		anony.method2(
				new Vehicle() {					
					@Override
					public void run() {
						System.out.println("트럭이 달립니다");
					}
				});

	}

}
