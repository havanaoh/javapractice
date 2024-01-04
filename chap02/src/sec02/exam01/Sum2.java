package sec02.exam01;

import java.util.Scanner;

public class Sum2 {
	
	public static void sum_multi (int num1, int num2, String op) {
		if (op.equals("+")) {
			int result = num1 + num2;
			 System.out.println("덧셈 결과:" + result);
		} else if(op.equals("*")) {
			int result = num1 * num2;
		 	 System.out.println("곱셈 결과:" + result);	
		}
	}
		
	
	public static void main(String[] args, String op) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫번째 수:");
		 String strNum1 = scanner.nextLine();
		 System.out.print("두번째 수:");
		 String strNum2 = scanner.nextLine();
		 int num1 = Integer.parseInt(strNum1);
		 int num2 = Integer.parseInt(strNum2);
		sum_multi(num1, num2, op); // 여긴 왜 Scanner가 안들어가는걸까용
				
	}

	
 }
