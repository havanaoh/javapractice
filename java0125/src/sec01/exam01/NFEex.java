package sec01.exam01;

public class NFEex {

	public static void main(String[] args) {
		
		try {
			int x = Integer.parseInt("aa");
			System.out.println(x);	
		}catch(NumberFormatException e){
			System.out.println("오류발생");
		}
		
	}

}
