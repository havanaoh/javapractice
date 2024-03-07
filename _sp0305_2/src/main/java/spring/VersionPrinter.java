package spring;

import lombok.Setter;

@Setter
public class VersionPrinter {
	private int majorVersion;
	private int minorVersion;
	
	public void print() {
		System.out.println("이 프로그램의 버전은 %d.%d 입니다.\n \n" );
	}
	
	
}
