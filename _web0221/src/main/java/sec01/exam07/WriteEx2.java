package sec01.exam07;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteEx2 {

	public static void main(String[] args) {
		try(Writer writer = new FileWriter("c:temp/test5.db")){
			char[] array = {'A', 'B', 'C'};
			writer.write(array);
			writer.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
