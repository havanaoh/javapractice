package sec03.exam01;

import java.io.IOException;
import java.util.Scanner;

public class GetLineEx {

	public static void main(String[] args) throws IOException {
//		InputStream is = System.in;
//		Reader reader = new InputStreamReader(is);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner br = new Scanner(System.in);
		while(true) {
			System.out.println("입력하세요 : ");
//			String linestr = br.readLine();
			String lineStr = br.nextLine();
			if(lineStr.equals("q") || lineStr.equals("quit")) {
				break;
			}
			System.out.println("입력된 내용: " + lineStr);
		}
		System.out.println("종료합니다.");
		br.close();
	}

}
