package sec01.exam01;

public class Exam05 {

	public static void main(String[] args) {
		
//		int[] array2 = {80,78,97};
		int[] array = new int[] {83, 90, 87};

		int sum = 0;
		double avg = 0;
		
		
		for (int i=0; i < array.length; i++) {
			sum += array[i];
			
		}
		
		for (int num : array) {
			sum += num;
		}
		
		System.out.println("총합: " + sum);
		avg = (double) sum / array.length;
		System.out.println("평균: " + avg);
		
	}

}

