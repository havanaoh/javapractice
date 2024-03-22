package ss0321;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	private MemberDao dao;
	
	public MemberDto selectById(int id) {
		return dao.selectById(id);
	}
	
	public List<MemberDto> selectAll() {
		return dao.selectAll();
	
	}
	public void insert(MemberDto member) {
		dao.insert(member);
	}
	public void update(MemberDto member) {
		dao.insert(member);
	}
	public void delete(MemberDto member) {
		dao.insert(member);
	}
	
}
