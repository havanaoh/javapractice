package sec01;

public class Test {

	public static void main(String[] args) {
		int a[] = {1,3,10,2,8};
		
		//1. 합계를 구하는 프로그램을 만드세요
		int sum = 0, count = 0, max = 0;
		double avg = 0;
		
		for(int i=0; i < a.length; i++) {
			sum += a[i];
			count++;
			if(max < a[i]) {
				max = a[i];
			}
		}
		System.out.println("sum : " + sum);
		
		//2. 평균을 구하는 프로그램을 만드세요
		avg = sum / (double) count /* = a.length */;
		System.out.println("avg : " + avg);
		
		//3. 최대값을 출력하는 프로그램을 만드세요.
		System.out.println("max : " + max);
			
			
			
		

	}

}
