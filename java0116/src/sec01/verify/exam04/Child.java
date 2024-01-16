package sec01.verify.exam04;

public class Child extends Parent {
	private int studentNo;
	
	public Child(String name, int studentNo) {
		super(name); // 답
		this.name = name;
		this.studentNo = studentNo;
	}
}
