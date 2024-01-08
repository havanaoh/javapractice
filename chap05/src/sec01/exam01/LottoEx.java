package sec01.exam01;

import java.util.Random;

public class LottoEx {

	public static void main(String[] args) {
		int[] lotto = new int[6]; // index = 0~5, 개수 6개
		
		Random rand = new Random();
		
		
		for (int i=0; i<lotto.length; i++) {
			lotto[i] = rand.nextInt(45)+1;
			System.out.println(lotto[i]);
		// 몇번째 순서가 필요하면 해당건	
		}
		
		System.out.println("--------------------");
		
		for (int val : lotto) {
			System.out.println(val);
		// 순서 필요없으면 해당건
		}
		
	}

}
