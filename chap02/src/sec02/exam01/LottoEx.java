package sec02.exam01;

import java.util.Random;
import java.util.Scanner;

public class LottoEx {

	public static void main(String[] args) {
//		System.out.println(Math.PI);
		
		//난수 발생 1번
//		for (int i=0; i < 5; i++) {
//			int num = (int) (Math.random()*45 +1) ;
//			System.out.println(num); // 난수발생
//					
//		}
//		
//		System.out.println("------------");
//		
//		// 난수 발생 2번
//		Random rd = new Random();
//		for (int j=0; j<6; j++) {
////		System.out.println(rd.nextInt(45)); // 0~45
//			System.out.println(rd.nextInt(44)+1); // 1~45
//		}
		
		Random rd1= new Random();
		Random rd2= new Random();
		
		int num1 = rd1.nextInt(99);
		int num2 = rd2.nextInt(99);
		
		System.out.println(num1 + " X " + num2);
		
		System.out.println("입력>");
				
		while (true) {
			Scanner scanner = new Scanner(System.in);
			int inputNumber = scanner.nextInt();
			
			
			if ( inputNumber == num1*num2) {
				System.out.println("정답입니다");
				break;
			} else {
				System.out.println("틀렸습니다");
				
			}
			}
			
			
		}
		
		
		
		}
		
		
		
	


