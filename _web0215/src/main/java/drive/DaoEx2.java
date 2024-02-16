package drive;

import java.util.List;

import dao.BoardDao;
import dto.Board;

public class DaoEx2 {

	public static void main(String[] args) {
		BoardDao dao = BoardDao.getInstance();
		List<Board> list = dao.selectList(); // null 대신 selectList()를 호출해 보세요.
		// list에 들어있는 객체들을 출력해 보세요.
		list.stream().forEach(s->{
			System.out.println(s);
		});
//		for(Board board : list) {
//			System.out.println(board);
//		}
	}

}
