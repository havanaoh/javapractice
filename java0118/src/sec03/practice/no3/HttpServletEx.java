package sec03.practice.no3;

public class HttpServletEx {

	public static void main(String[] args) {
		method(new LoginServlet()); // 로그인합니다.
		method(new FileDownloadServlet()); // 파일 다운로드 합니다.
	}
	
	public static void method(HttpServlet servlet) {
		servlet.service();
	}

}
