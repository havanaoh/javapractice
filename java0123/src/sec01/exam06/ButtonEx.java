package sec01.exam06;

import java.util.Scanner;

public class ButtonEx {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Button bt = new Button();
		Button.OnClickListener listener = null;
		System.out.println("선택 (1: 전화, 2:메세지)");
		String str = scan.nextLine();
		switch(str) {
		case "1" : 
			listener = new CallListener();
			break;
		case "2" : 
			listener = new Messageistener();
			break;
		default:
			System.out.println("다시 선택하시기 바랍니다.");
		}
		bt.setOnClickListener(listener);
		bt.touch();
	}
}
