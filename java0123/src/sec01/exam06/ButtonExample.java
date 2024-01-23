package sec01.exam06;

public class ButtonExample {
	public static void main(String[] args) {
		Button bt = new Button();
		bt.setOnClickListener(new CallListener());
		bt.touch();
		bt.setOnClickListener(new Messageistener());
		bt.touch();
	}
}
