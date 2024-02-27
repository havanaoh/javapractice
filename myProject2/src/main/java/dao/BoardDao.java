package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Board;

public class BoardDao {

	private static Connection conn;
	private static BoardDao dao = new BoardDao();

	private BoardDao() {
	}

	public static BoardDao getInstance() {
		BoardDao.getConnection();
		return dao;
	}

	private static void getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tigger");
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
				Board board = new Board(rs.getInt("boardno"), rs.getString("title"), rs.getString("content"),
						rs.getString("regtime"), rs.getInt("hits"), rs.getInt("memberno"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public Board selectOne(int num, boolean inc) {
		Board board = null;
		String sql = "select * from board where boardno = ?";
		PreparedStatement pstmt;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				board = new Board(rs.getInt("boardno"), rs.getString("title"), rs.getString("content"),
						rs.getString("regtime"), rs.getInt("hits"), rs.getInt("memberno"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return board;
	}

	public int delete(int boardnum) {
		int result = 0;
		try (PreparedStatement pstmt = conn.prepareStatement("delete from board where boardnum = ? " + boardnum)) {
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int insert(Board board) {
		String sql = "insert into board " + "(boardno, title, content, regtime, hits)" + "value (?, ?, ?, sysdate, 0)";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, board.getBoardno());
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
		String sql = "update board set title = ?, content = ?, " + "regtime = sysdate where boardno = ?";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getRegtime());
			pstmt.setInt(4, board.getBoardno());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
