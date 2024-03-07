package spring;

import java.util.Collection;

public class MemberListPrint {
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	public MemberListPrint(MemberDao memberDao, MemberPrinter printer) {
		super();
		this.memberDao = memberDao;
		this.printer = printer;
	}
	
	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
		members.stream().forEach(a-> {
			printer.print(a);
		});
//		members.forEach(m->printer.print(m));
		
//		for(Member member : members) {
//			printer.print(member);
//		}
		
		
		
	}
}
