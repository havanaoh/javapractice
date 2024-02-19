package ramda;

public class MyFruntionalInterfaceEx {

	public static void main(String[] args) {
		MyFruntionalInterface f1, f2;

		f2 = new MyFruntionalInterface() {

			@Override
			public int method(int x, int y) {

				return sum(x, y);
			}

		};

		f1 = (a, b) -> sum(a, b);

		int z = f1.method(10, 20);
		System.out.println(f1.method(10, 20));

	}

	public static int sum(int x, int y) {
		return x + y;
	}

}
