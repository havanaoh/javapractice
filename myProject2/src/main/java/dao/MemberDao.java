package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.MemberDto;

public class MemberDao {

    // DB에 접속하여 Connection 객체를 반환
    private Connection getConnection() throws Exception {

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection(
        		"jdbc:oracle:thin:@localhost:1521:xe", "scott", "tigger");

        return conn;
    }


    // 멤버 인원수 얻기
    public int getNumRecords() {
        int numRecords = 0;

        try (
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(
                    "select count(*) from member");
        ) {
            if (rs.next()) {
                numRecords =  rs.getInt(1);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return numRecords;
    }

    // 멤버 리스트 읽기
    public ArrayList<MemberDto> selectList(int start, int listSize) {

        ArrayList<MemberDto> dtoList = new ArrayList<MemberDto>();

        try (
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(String.format(
                    "select * from (select * from member order "
                    + "by memberno desc) where rownum between %d and %d",
                    start, listSize));
        ) {
            while (rs.next()) {

                // 새 DTO 객체를 만들고 멤버 데이터를 이 객체에 저장
                MemberDto dto = new MemberDto();

                dto.setMemberno(rs.getInt("memberno"));
                dto.setId(rs.getString("id"));
                dto.setEmail(rs.getString("email"));
                dto.setName(rs.getString("name"));

                // 이 DTO 객체를 ArrayList에 추가
                dtoList.add(dto);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return dtoList;
    }

    // 지정된 멤버 번호를 가진 레코드 읽기
    public MemberDto selectOne(int memberno) {
        MemberDto dto = new MemberDto();
        try (
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "select * from member where memberno=" + memberno);
        ) {
            if (rs.next()) {
                // 멤버 데이터를 DTO에 저장
            	dto.setMemberno(rs.getInt("memberno"));
                dto.setId(rs.getString("id"));
                dto.setEmail(rs.getString("email"));
                dto.setName(rs.getString("name"));                
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return dto;
    }
    
    // 지정된 멤버 id, pw를 가진 레코드 읽기
    public MemberDto selectMember(String id, String email) {
        MemberDto dto = new MemberDto();
        String sql = "select * from member where id=? and email=?";
        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = 
            		conn.prepareStatement(sql);
        ) {
        	pstmt.setString(1, id);
        	pstmt.setString(2, email);
        	ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                // Member 데이터를 DTO에 저장
            	dto.setMemberno(rs.getInt("memberno"));
                dto.setId(rs.getString("id"));
                dto.setEmail(rs.getString("email"));
                dto.setName(rs.getString("name"));                
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }

        return dto;
    }

    // DTO에 담긴 내용으로 새로운 레코드 저장
    public void insertOne(MemberDto dto) {

        try (
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
        ) {
            stmt.executeUpdate(String.format(
                    "insert into member " +
                    "(memberno, id, email, name)" +
                    "values (SEQ_member.nextval, '%s', '%s', '%s')",
                    dto.getId(), dto.getEmail(), dto.getName()));

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // DTO에 담긴 내용으로 멤버 데이터 업데이트
    public void updateOne(MemberDto dto) {		
		try (Connection conn = getConnection(); 
			Statement stmt = conn.createStatement();
		) {
			stmt.executeUpdate(String.format(
					"update member set email='%s', name='%s' where Memberno=%d",
							dto.getEmail(), dto.getName(), dto.getMemberno()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    // 지정된 멤버 번호의 레코드 삭제
    public void deleteOne(int memberno) {

        try (
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
        ) {
            stmt.executeUpdate("delete from member where memberno=" + memberno);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}