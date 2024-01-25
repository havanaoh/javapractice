package sec01.exam01;

public class AOOBex {

	public static void main(String[] args) {
		int[] arr = new int[4];
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println(arr[4]); // 4번째 인덱스가 없어서 오류남
	}

}
