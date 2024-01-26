package sec01.exam01;

public class MemberEx {

	public static void main(String[] args) {
		Member obj1 = new Member("blue");
		Member obj2 = new Member("BLUE");
		Member obj3 = new Member("red");
		Member obj4 = new Member("blue");
		
		System.out.println(obj1.hashCode());
		System.out.println(obj1);
		System.out.println(obj2.hashCode());
		System.out.println(obj3.hashCode());
		System.out.println(obj4.hashCode());
	
		if(obj1.equals(obj2)) {
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		
		if(obj2.equals(obj3)) {
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
	
	}
	
	
}
