package main;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import spring.Member;
import spring.MemberDao;

public class MainForDao {
	
	private static Logger LOGGER = LoggerFactory.getLogger(MainForDao.class);
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppCtx.class);
		MemberDao dao = ctx.getBean(MemberDao.class);
		
//		Member member = dao.selectByEmail("madvirus@madvirus.net1");
//		Member member2 = dao.selectByEmail("madvirus@madvirus.net");
//		LOGGER.info("{}", member);
//		LOGGER.info("{}", member2);
		
		Member member2 = new Member("bbb@korea.com", "1234", "김하나", null);
		dao.insert2(member2);
		LOGGER.info("===한 행이 입력 되었습니다. =====");
		LOGGER.info("새로 입력된 Id : {}", member2.getId());
		
		
		Member member3 = new Member("aaa@korea.com", "5678", "홍길순", null);
		dao.update(member3);
		LOGGER.info("======================"
				+ "update");
		
		Member member = dao.selectByEmail("madvirus@madvirus.net");
		LOGGER.info("================================================"
				+ "아이디 : {}, 이메일 : {}, 패스워드 : {}, 이름 : {}, 등록일 : {}",
				member.getId(),
				member.getEmail(),
				member.getPassword(),
				member.getName(),
				member.getRegisterDateTime());	

		List<Member> list = dao.selectAll();
		LOGGER.info("테이블 내용 ");
		for(Member member1 : list) {
			LOGGER.info(member1.toString());	
		}		
		LOGGER.info("테이블 끝");
	
		int cnt = dao.count();
		LOGGER.info("총 인원 수 : {}", cnt);
		
		
	
	}
	

}

