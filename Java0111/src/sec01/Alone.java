package sec01;

public class Alone {

	public static void main(String[] args) {
		int a[] = {1,3,10,2,8};
		
		int sum=0, max = 0;
		double avg = 0;
		for(int i = 0; i<a.length; i++) {
			sum += a[i];
			if(max<a[i]) {
				max = a[i];
			}
			avg = sum /(double)a.length;	
		}
		System.out.println("최댓값 : " + max);
		System.out.println("합 : " + sum);
		System.err.println("평균 : " + avg);

	}

}
