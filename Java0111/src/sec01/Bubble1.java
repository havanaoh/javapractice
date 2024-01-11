package sec01;

public class Bubble1 {
	public static void printArr(int a[]) {
		for (int n : a) {
			System.out.print(n + ",");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int a[] = { 10, 3, 1, 4, 2 };

		printArr(a);

		for (int i = 0; i < a.length; i++) { // 횟수 때문에 생김
			for (int j = 0; j < a.length - 1; j++) {
				if (a[j] > a[j + 1]) {
					// 자료 교환 서로 값 바꾸기 (swap)
					int tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
					printArr(a);
				}
			}
		}
		printArr(a);

	}

}
