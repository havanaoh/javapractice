package sec01.exam12;

public class StringCharAtEx {

	public static void main(String[] args) {
		String ssn = "010624-1230123";
		char sex = ssn.charAt(7);
		switch (sex) {
		case '1' :
		case '3' :
			System.out.println("male");
			break;
		case '2' :
		case '4' :
			System.out.println("female");
			break;
		}

	}

}
