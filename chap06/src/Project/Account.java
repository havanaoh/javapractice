package Project;

public class Account {
	String name; // 이름 필드(아이디로 사용)
	String ssn;	 // 생년월일 (패스워드로 사용)
	String tel;  // 
	int age;
	
	public Account() {
		System.out.println("내가만든 Account()");
	
	}
	
	public Account(String str) {
		
	}
		
	public Account(String name, String ssn, String tel, int age) {
		super();
		this.name/*필드에 있는 놈이라고 명시해주는것*/= name;
		this.ssn = ssn;
		this.tel = tel;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", ssn=" + ssn + ", tel=" + tel + ", age=" + age + "]";
	}
	
	
	
}
