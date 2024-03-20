package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import dto.BoardDto;

public class BoardDao {

	// DB에 접속하여 Connection 객체를 반환
	private Connection getConnection() throws Exception {

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tigger");

		return conn;
	}

	// 현재 시간을 문자열 형태로 반환
	private String getCurrentTime() {
		return LocalDate.now() + " " + LocalTime.now().toString().substring(0, 8);
	}

	// 게시글 갯수 얻기
	public int getNumRecords() {
		int numRecords = 0;
		try (Connection conn = getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select count(*) from board");
		) {
			if (rs.next()) {
				numRecords = rs.getInt(1);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return numRecords;
	}

	// 게시글 리스트 읽기
	public ArrayList<BoardDto> selectList() {

		ArrayList<BoardDto> dtoList = new ArrayList<BoardDto>();

		try (Connection conn = getConnection();
				Statement stmt = conn.createStatement();

				ResultSet rs = stmt.executeQuery
						(String.format("select * from board natural join member order by boardno desc"
							));
				){				
			while (rs.next()) {
				// 새 DTO 객체를 만들고 글 데이터를 이 객체에 저장
				BoardDto dto = new BoardDto();
				dto.setBoardno(rs.getInt("boardno"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegtime(rs.getString("regtime"));
				dto.setHits(rs.getInt("hits"));
				// 이 DTO 객체를 ArrayList에 추가
				dtoList.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}


//		public ArrayList<BoardDto> selectList(int start, int listSize) {
//
//			ArrayList<BoardDto> dtoList = new ArrayList<BoardDto>();
//
//			try (Connection conn = getConnection();
//					Statement stmt = conn.createStatement();
//
//					ResultSet rs = stmt.executeQuery
//							(String.format("select * "
//									+ "from (SELECT ROWNUM rn, b.*"
//									+ "FROM (SELECT * FROM board ORDER BY boardno DESC) b)"
//									+ "where rn BETWEEN ? and ?",
//									start, listSize));)
//					ResultSet rs = stmt.executeQuery(String.format
//							("SELECT * FROM (select * from board "
//							+ "NATURAL JOIN member)WHERE ROWNUM BETWEEN %d AND %d",
//							start, listSize)); 
//				{
//				while (rs.next()) {
//					// 새 DTO 객체를 만들고 글 데이터를 이 객체에 저장
//					BoardDto dto = new BoardDto();
//					dto.setBoardno(rs.getInt("boardno"));
//					dto.setName(rs.getString("name"   ));
//					dto.setTitle(rs.getString("title"));
//					dto.setContent(rs.getString("content"));
//					dto.setRegtime(rs.getString("regtime"));
//					dto.setHits(rs.getInt("hits"));
//					// 이 DTO 객체를 ArrayList에 추가
//					dtoList.add(dto);
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return dtoList;
//		}
	
	
	
	
	// 지정된 글 번호를 가진 레코드 읽기
	// hitsIncreased가 true이면 해당 글의 조회수를 1 증가시킴
	// false이면 조회수를 증가시키지 않음
	public BoardDto selectOne(int boardno, boolean hitsIncreased) {

		BoardDto dto = new BoardDto();

		try (Connection conn = getConnection();
				Statement stmt = conn.createStatement();

				ResultSet rs = stmt
						.executeQuery("select * from board NATURAL JOIN member where boardno =" + boardno);) {
			if (rs.next()) {

				// 글 데이터를 DTO에 저장
				dto.setBoardno(rs.getInt("boardno"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegtime(rs.getString("regtime"));
				dto.setHits(rs.getInt("hits"));

				// 이글의 조회수를 증가시켜야 하는 경우
				// (글 보기 화면을 위해 읽을 때)이면 조회수 1 증가
				if (hitsIncreased) {
					stmt.executeUpdate("update board set hits=hits+1 where boardno =" + boardno);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}

	// DTO에 담긴 내용으로 새로운 레코드 저장
	public void insertOne(BoardDto dto) {

		try (Connection conn = getConnection(); Statement stmt = conn.createStatement();) {
			stmt.executeUpdate(String.format(
					"insert into board (boardno, title, content, regtime, hits, memberno)"
							+ "values (SEQ_BOARD.nextval, '%s', '%s', sysdate, 0, '%d')",
					dto.getTitle(), dto.getContent(), dto.getMemberno()));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// DTO에 담긴 내용으로 게시글 데이터 업데이트
	public void updateOne(BoardDto dto) {		
		try (Connection conn = getConnection(); 
			Statement stmt = conn.createStatement();
		) {
			stmt.executeUpdate(String.format(
					"update board set title='%s',content='%s', regtime=sysdate "
							+ "where boardno=%d",
							dto.getTitle(), dto.getContent(), dto.getBoardno()));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 지정된 글 번호의 레코드 삭제
	public void deleteOne(int boardno) {

		try (Connection conn = getConnection(); Statement stmt = conn.createStatement();) {
			stmt.executeUpdate("delete from board where boardno=" + boardno);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
