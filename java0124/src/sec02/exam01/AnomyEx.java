package sec02.exam01;

public class AnomyEx {
	public static void main(String[] args) {
		Anonymous anony = new Anonymous();
		anony.field.wake();
		anony.method1();
		anony.method2(
				new Person(){
				void study() {
					System.out.println("study");
				}

				@Override
				void wake() {
					System.out.println("8시 wake");
				}
				
			
				}
		);
	
		}
}
