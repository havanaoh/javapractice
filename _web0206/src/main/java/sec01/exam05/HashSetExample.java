package sec01.exam05;

import java.util.*;

public class HashSetExample {
	public static void main(String[] args) {
		Set<Member> set = new HashSet<Member>();
		
		Member mb1 = new Member("홍길동", 30);
		Member mb2 = new Member("홍길동", 30);
		
		System.out.println(mb1.hashCode());
		System.out.println(mb2.hashCode());
		
		set.add(new Member("홍길동", 30));
		set.add(new Member("홍길동", 30));
		
		System.out.println("총 객체수 : " + set.size());
	}
}

