package ss0321;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public MemberDto selectById(int id) {
		List<MemberDto> list = jdbcTemplate.query(
				"select * from member where id = ?",
				(rs, rowNum)->{
					MemberDto member = new MemberDto(
							rs.getInt("id"),
							rs.getString("name"),
							rs.getInt("age"),
							rs.getString("email"),
							rs.getString("memo"));					
					
					return member;
				},
				id);		
		return list.isEmpty() ? null : list.get(0);
	}
	
	public List<MemberDto> selectAll(){
		List<MemberDto> list = jdbcTemplate.query(
				"select * from member",
				(rs, rowNum)->{
					MemberDto member = new MemberDto(
							rs.getInt("id"),
							rs.getString("name"),
							rs.getInt("age"),
							rs.getString("email"),
							rs.getString("memo"));					
					
					return member;					
				});
		return list;
	}
	public void insert(MemberDto member) {
		jdbcTemplate.update(
				"insert into member (name, age, email, memo"
				+ "values (?, ?, ?, ?)",
				member.getName(), member.getAge(), 
				member.getEmail(), member.getMemo());
		System.out.println(member);
	}
	
	public void update(MemberDto member) {
		jdbcTemplate.update(
				"update member set "
				+ "name = ?, age = ?, email =?, memo =? where id = ?",
				member.getName(), member.getAge(), 
				member.getEmail(), member.getMemo(),
				member.getId());
	}
	
	public void delete(MemberDto member) {
		jdbcTemplate.update(
				"delete from member where id = ?",
				member.getId());		
	}

	
}
