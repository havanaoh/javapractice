package sec01;

public class PracticeNo5 {

	public static void main(String[] args) {
		int[][] array = {
				{95, 86},
				{83, 92, 86},
				{78, 83, 93, 87, 88}
								
		};
		
		int sum = 0;
		double avg = 0, count = 0;
		
		
		for (int[] arr : array) {
			for(int num : arr) {
				sum += num;
				count++;
			}
		}
		avg = sum/count;
		System.out.println("sum : " + sum);
		System.out.println("avg : " + avg);
	}

}
