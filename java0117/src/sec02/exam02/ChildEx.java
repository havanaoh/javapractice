package sec02.exam02;

public class ChildEx {

	public static void main(String[] args) {
		Child child = new Child();
		
		Parent parent = child; // 대입 가능
		parent.method1();
		parent.method2();
//		parent.method3(); 오류남 
		}

}
