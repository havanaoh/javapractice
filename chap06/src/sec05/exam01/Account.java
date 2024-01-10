package sec05.exam01;

public class Account {
	String name; // 이름 필드(아이디로 사용)
	String ssn;	 // 생년월일 (패스워드로 사용)
	String tel;  // 
	int balance;
	
	
	
	public Account(String name, String ssn, String tel) {
		super();
		this.name = name;
		this.ssn = ssn;
		this.tel = tel;
	}

	public Account(String name, String ssn, String tel, int balance) {
		this.name = name; /*필드에 있는 놈이라고 명시해주는것*/
		this.ssn = ssn;
		this.tel = tel;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", ssn=" + ssn + ", tel=" + tel + ", balance=" + balance + "]";
	}

	
	
	

}
