package thread;

public class SleepEx {

	public static void main(String[] args) {
		// 7~15만 있으면 싱글 스레드
		for(int i=0; i<3; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	} 

}
