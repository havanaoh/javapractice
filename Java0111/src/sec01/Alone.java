package sec01;

public class Alone {

	public static void main(String[] args) {
		int a[] = { 1, 3, 10, 2, 8 };

		int sum = 0, max = 0;
		double avg = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			if (max < a[i]) {
				max = a[i];
			}
			avg = sum / (double) a.length;
		}
		System.out.println("최댓값 : " + max);
		System.out.println("합 : " + sum);
		System.err.println("평균 : " + avg);

		for (int i = 0; i < a.length; i++) {
			if (a[i] == 10) {
				System.out.println("인덱스 : " + (i));
			}

		}
		// 값 변환
		int x = 10;
		int y = 20;
		int tem = 0;

		System.out.println("x" + x);
		System.out.println("y" + y);

		tem = y;
		y = x;

		System.out.println("x" + tem);
		System.out.println("y" + y);
	}
}
