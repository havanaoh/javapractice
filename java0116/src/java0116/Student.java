package java0116;

public class Student extends People {
	String hakbun;
	
	public Student(String hakbun) {
		super(); // 부모의 생성자 호출 (부모의 기본 생성자 호출? ㅇㅇ 아무것도 없어서 기본생성자 맞음)
		this.hakbun = hakbun;
	}

	@Override
	void method1() {
		System.out.println();
		super.method1(); // 보모의 메소드 실행(생략 가능)
	}
	
	
	
}
