package spring;

import java.util.Collection;

public class MemberListPrinter {
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
		this.memberDao = memberDao;
		this.printer = printer;
	}
	
	
	//해쉬맵구조를 받아 반복문을 돌린다.
	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
		
		
		//members.stream().forEach(a ->{
		//	printer.print(a);
			
		//});
		
		members.forEach(m -> printer.print(m));
		//for(Member member : members) {
		//	printer.print(member);
		//}
	}
}
