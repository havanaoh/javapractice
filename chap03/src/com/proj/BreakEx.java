package com.proj;

public class BreakEx {

	public static void main(String[] args) {
		for (int i=0; i<100; i++) {
			if(i==55) {
//				System.out.println(i);
//				break; // 루프를 탈출
				continue; //  시작 시점으로 감
			}
			System.out.println(i); // 문제? 마지막 숙자가 몇일까요 -> 이미 해봤는데... 54
		}
		System.out.println("종료");
	}

}
