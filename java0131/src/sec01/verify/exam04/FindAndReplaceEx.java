package sec01.verify.exam04;

public class FindAndReplaceEx {

	public static void main(String[] args) {
		String str = "모든 프로그램은 자바 언어로 개발될 수 있다.";
		int index = str.indexOf("자바"); // 위치를 정수로
		System.out.println(index);
		str = str.replace("자바", "java"); // 새로운 문자열로 대체
		System.out.println(str);
		if(index == -1) {
			System.out.println("자바 없음");
			
			
		}else {
			System.out.println("자바 있음");
		}
		
		String strData1 = "200";
		int intData1 = Integer.parseInt(strData1);
		int intData2 = 150;
		String strData2 = String.valueOf(intData2);
		
		
		
	}

}
