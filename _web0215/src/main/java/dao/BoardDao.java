package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Board;

public class BoardDao {
// p.280 참고

	private static Connection conn;
	private static BoardDao dao = new BoardDao();

	private BoardDao() {} // 생성자

	public static BoardDao getInstance() {
		BoardDao.getConnection();
		return dao;
	}

	private static void getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/project1", "root", "mysql");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ArrayList<Board> selectList() {
		ArrayList<Board> list = new ArrayList<Board>();
		String sql = "select * from board order by num desc";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Board board = new Board(rs.getInt("num"), rs.getString("writer"), rs.getString("title"),
						rs.getString("content"), rs.getString("regtime"),
						rs.getInt("hits"));
				list.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public Board selectOne(int num, boolean inc) {
		Board board = null;
		String sql = "select * from board where num = ?";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				board = new Board(rs.getInt("num"), rs.getString("writer"), 
						rs.getString("title"),rs.getString("content"), 
						rs.getString("regtime"), rs.getInt("hits"));

			}
			if(inc) {
				pstmt.executeUpdate(
						"update board set hits = hits+1 where num = " + num);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return board;

	}
		
	public int delete(int num) {
		int result = 0;
		try (PreparedStatement pstmt = conn.prepareStatement(
				"delete from board where num = " + num);
			){
			result = pstmt.executeUpdate();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return result;
	}
	
	public int insert(Board board) {
		String sql = "insert into board (writer, title, content, "
				+ "regtime, hits) values (?, ?, ?, now(, 0)";
		try (PreparedStatement pstmt = conn.prepareStatement(sql);
			){
			pstmt.setString(1, board.getWriter());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getContent());			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int update(Board board) {
		String sql = "update board set writer = ?, title =?, content = ?, "
				+ "regtime = now() where num = ?";
		try ( PreparedStatement pstmt = conn.prepareStatement(sql);
				
			){
			pstmt.setString(1, board.getWriter());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getContent());			
			pstmt.setInt(4, board.getNum());
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
}
