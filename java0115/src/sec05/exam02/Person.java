package sec05.exam02;

public class Person {
	public static final double PI = 3.141592; // 상슈
	final static public double PI1 = 3.141592; // 상슈
	
	final String name;
	
	public Person(String name) {
		this.name = name;
	}
	
	
	public static void main(String[] args) {
		Person person = new Person("홍길동");
//		person.name = "홍길동";
		
		final int x; // 한번만 초기화 가능
		x = 300;
//		x = 500;
	}

}
