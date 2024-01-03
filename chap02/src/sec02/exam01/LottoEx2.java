package sec02.exam01;

import java.util.Random;
import java.util.Scanner;

public class LottoEx2 {
	
	public static int creatNumber(Random random) {
//		Random random = new Random();
		return random.nextInt(10)+1;
	}
	public static void multiplication() {
			Random random = new Random();
			Scanner scan = new Scanner(System.in);

			int num1 = creatNumber(random);
			int num2 = random.nextInt(10) + 1;
			int multi = num1 * num2;

			System.out.printf("%d X %d = ?\n", num1, num2);
			for (;;) {
				System.out.print("입력>");
				int answer = Integer.parseInt(scan.nextLine());
				if (answer == multi) {
					System.out.println("정답입니다!");
					break;
				} else {
					System.out.println("오답입니다!");
				}

			}

		}
	

	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			multiplication();
		}
		System.out.println("종료");
	}

}
