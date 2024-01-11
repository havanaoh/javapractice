package sec01;


public class Test4 {

	public static void main(String[] args) {
		int a[] = {10, 3, 1, 4, 2};
		// 값 4가 있는 인덱스를 출력하는 프로그램을 만드세요
		int idx = -1;
		for (int i=0; i < a.length; i++) {
			if(a[i]==4) {
				idx = i;
			}
		}
		if(idx != -1) {
			System.out.println("인덱스:" +idx);
		} else {
			System.out.println("못찾음");
		}
		
		//자료 교환 문제
		int x = 10;
		int y = 20;
		int tem = 0;
		
		System.out.println(x);
		System.out.println(y);
		
		tem = y;
		y = x;
		
		System.out.println(tem);
		System.out.println(y);

		
		//5. 버블소트를 구현해 보세요.
		for (int i=0; i<a.length; i++) {
			for(int j=0; j<a.length-1; j++) {
				if(a[j]>a[j+1]) {
					int tem1 = a[j];
					a[j] = a[j+1];
					a[j+1] = tem1;
									
				}
				
			}
		}
		for (int arr : a) {
			System.out.print(","+ arr);
		}
						
	}

}
