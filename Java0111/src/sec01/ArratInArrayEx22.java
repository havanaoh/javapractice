package sec01;

import java.util.Scanner;

public class ArratInArrayEx22 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("점수1 입력 :");
		int n1 = scan.nextInt();
		System.out.println("점수2 입력 :");
		int n2 = scan.nextInt();
		int[][] scores = new int[n1][n2];
		
		for(int i=0; i< scores.length; i++) {
			for(int j=0; j < scores[i].length; j++) {
			System.out.println("socores[" + i +"]>");
			scores[i][j] = Integer.parseInt(scan.nextLine());
			}
//		for (int i = 0; i < scores.length; i++) {
//			for (int j = 0; j < scores[i].length; j++) {
//				System.out.printf("(%d, %d:", i, j);			
//				System.out.println(scores[i][j]);
			System.out.println(scores);
			}
			
		}

}


