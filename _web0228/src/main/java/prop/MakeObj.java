package prop;

public class MakeObj {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> handlerClass = Class.forName("prob.Aaa");
		Aaa handlerInstance = (Aaa) handlerClass.newInstance();
		
		handlerInstance.aaaprint();
	}

}
