package test0130;

interface Aaa {
	void bbb();
}

public class Ex {

	public static void main(String[] args) {
		Aaa ss = new Aaa() {

			@Override
			public void bbb() {
				// TODO Auto-generated method stub
				
			}
			
		};
		
		int a = 10;
		int b = 20;
		int c = 0;
		c = b;
		b = a;
		System.out.println(c);
		System.out.println(b);

		int[] sc = {95, 71, 84};
		int sum = 0;
		for(int nn : sc) {
			sum = sum + nn;
		}
		System.out.println(sum);
		double avg = (double) sum/3;
		System.out.println(avg);
		
		byte t;
		short s;
		int n;
		char h;
		
		
	}
	
	

}
