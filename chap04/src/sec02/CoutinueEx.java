package sec02;

import java.util.Scanner;

public class CoutinueEx {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = null;
		int[] arr2 = null;
		
		System.out.print("크기:");
		int size = scan.nextInt();
		arr2 = new int[size];
		
		arr = arr2; // 힙에 있는 메모리 주소값을 복사
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr2[i]);
		}
		
		arr2[1] = 100;
		System.out.println(arr[1]);
	}

}
