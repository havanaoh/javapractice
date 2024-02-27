package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Board;

public class BoardDao {

	private static Connection conn;
	private static BoardDao dao = new BoardDao();
	
	private BoardDao() {}
	
	public static BoardDao getInstance() {
		BoardDao.getConnection();
		return dao;
	}
	
	private static void getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "scott", "tigger");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
	
	public static void selectList() {
		String sql = "select * from board order by boardno desc";
		PreparedStatement pstmt;		
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Board board = new Board(rs.getInt("boardno"),rs.getString("title"),
						rs.getString("content"), rs.getString("regtime"),
						rs.getInt("hits"), rs.getInt("memberno"));
				}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
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
				board = new Board(rs.getInt("boardno"),rs.getString("title"),
						rs.getString("content"), rs.getString("regtime"),
						rs.getInt("hits"), rs.getInt("memberno"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return board;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
