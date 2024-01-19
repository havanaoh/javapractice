package proxy;


public class Client {

	public static void main(String[] args) {
		/*
		Isubject sub1 = new RealSubject();
		sub1.action();
		Isubject sub = new Proxy(new RealSubject());
		sub.action();
		동일한 작동함
		*/
		
		Isubject sub = new Proxy(new RealSubject());
		sub.action();
		
	}

}
