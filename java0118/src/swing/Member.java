package swing;

import java.io.Serializable;


public class Member implements Serializable{
	private String name;
	private String id;
	private String pw;
	private String tel;
	private String ssn;
	private int balance;
	
	public Member(String name, String id, String pw, String tel, String ssn) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.tel = tel;
		this.ssn = ssn;
		
	}

	
	public Member(String name, String id, String pw, String tel, String ssn, int balance) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.tel = tel;
		this.ssn = ssn;
		this.balance = balance;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", id=" + id + ", pw=" + pw + ", tel=" + tel + ", ssn=" + ssn + ", balance="
				+ balance + "]";
	}

	public void deposit(int deposit) {
		if(deposit <= 0) {
			System.out.println("금액을 정확히 입력해주세요");
			return;
		}
		balance += deposit; 
	}
	
	public void withdraw(int withdraw) {
		if(withdraw > balance) {
			System.out.println("잔액이 부족합니다.");
		}
	}
	

	
	
}