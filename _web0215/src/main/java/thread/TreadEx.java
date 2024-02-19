package thread;

public class TreadEx {

	public static void main(String[] args) {
		Thread thread = new MovieThread();
		thread.start();
		
		
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		thread.interrupt();
	}

}
