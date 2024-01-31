package sec01.exam01;

public class BeepPrintEx2 {

	public static void main(String[] args) {
		Thread th = new Thread(new BeepTask());
		th.start(); 
		// run으로 해도 실행은 됨, 단일 스레드고 start 해야 멀티 쓰레드임

		
		for(int i=0; i<5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500); // 0.5초 잠시멈춤 
			} catch (InterruptedException e) {
				
			}	
		}
		System.out.println("main 종료");
	}

}
