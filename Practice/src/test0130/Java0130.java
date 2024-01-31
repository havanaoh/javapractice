package test0130;

public class Java0130 {

	public static void main(String[] args) {
		//no.3
		
		int[] arr = {5, 23, 1, 43, 100, 200, 40};
		for (int i=0; i<arr.length; i++) {
			for(int j = i+1; j<arr.length; j++) {
				if (arr[i]>arr[j]) {
					int temp = 0;
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					
				}
				
			}
			System.out.print(arr[i]+",");
		}
		

	}

}
