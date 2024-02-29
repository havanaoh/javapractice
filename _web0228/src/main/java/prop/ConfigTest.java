package prop;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigTest {

	public static void main(String[] args) throws IOException {
		String propFile = "sre/main/java/config.properties";
		Properties prop = new Properties();
		
		//프로퍼티 파일 스트림에 담기
		FileInputStream fis = new FileInputStream(propFile);
		
		//프로퍼티 파일 로딩
		prop.load(new BufferedInputStream(fis));
	
		//항복 읽어서 콘솔 출력
		System.out.println("db.ip");
		System.out.println("db.post");
		System.out.println("test");
		
	}

}
