package anoymous;

class Parent{
	void method() {}
}

public class Child extends Parent {
	@Override
	void method() {
		// TODO Auto-generated method stub
		super.method();
	}

	public static void main(String[] args) {
		Parent parent2 = new Child();
		Child child = (Child) parent2;
		new Child(); // 익명개체
		Parent parent1 = new Parent();
		
		
		Parent parent = new Parent(){
			@Override
			void method() {
				// TODO Auto-generated method stub
				super.method();
			}
		}; // 상속관계시 {}도 자식 클래스
	
	
	
	
	
	}

	
		
	
}
