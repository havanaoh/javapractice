package sec02.exam03;



public class Window {
	Button bt1 = new Button();
	Button bt2 = new Button();
	
	Button.OnClickListener listener = new Button.OnClickListener() {
		
		@Override
		public void onClick() {
		System.out.println("전화를 겁니다");
			
		}		
	}; 
	
	Window(){
		bt1.setOnClickListener(listener);
		bt2.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick() {
				System.out.println("메세지를 보냅니다");
				
			}
		});
	}
}
