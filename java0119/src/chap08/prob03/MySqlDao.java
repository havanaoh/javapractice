package chap08.prob03;

public class MySqlDao implements DataAccessObject {

	@Override
	public void select() {
		System.out.println("MySql DB select");
	}

	@Override
	public void insert() {
		System.out.println("MySql DB insert");
		
	}

	@Override
	public void update() {
		System.out.println("MySql DB update");
		
	}

	@Override
	public void delete() {
		System.out.println("MySql DB delete");
		
	}

}
