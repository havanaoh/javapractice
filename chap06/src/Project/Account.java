package Project;

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


	@Override
	public String toString() {
		return "Account [name=" + name + ", ssn=" + ssn + ", tel=" + tel + ", balance=" + balance + "]";
	}
	
	
	
	
}
