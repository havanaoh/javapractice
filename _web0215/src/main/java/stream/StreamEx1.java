package stream;

import java.util.Arrays;
import java.util.List;

public class StreamEx1 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		list.stream()		//스트림 생성
//		.filter(i->i%2==0)  // 중간 단계?
//		.map(i->i*2)
		.map(i->"요소는"+ i + "입니다.")
		.limit(3)
//		.forEach(i->System.out.println(i)); // 마지막단계 . 쳐도 더 안나옴
		.forEach(System.out::println); // :: 스태틱 method만 가능
		
		int x = (int) list.stream().filter(i->i==0).count();
		
		
		
//		 =new ArrayList<>();
//		list.add(1); list.add(2);
//		list.add(3); list.add(4);list.add(5); 
//		for(Integer i : list) {
//			if(i%2 == 0) { // 2의 배수 추출
//				System.out.println(i);
//			}
//		}



	}

}
