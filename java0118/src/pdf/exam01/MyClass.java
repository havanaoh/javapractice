package pdf.exam01;

public class MyClass implements InterTest {

	@Override
	public void test1() {
		System.out.println("새로운 test1()");
		
	}
	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		InterTest.test5();
		InterTest it = new MyClass();
		it.test1();

	}

}