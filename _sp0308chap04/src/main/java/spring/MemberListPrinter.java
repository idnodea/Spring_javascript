package spring;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberListPrinter {

	private MemberDao memberDao;
	@Autowired
	@Qualifier("printer")
	private MemberPrinter printer;

	public MemberListPrinter() {
	}
	
	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
		this.memberDao = memberDao;
		this.printer = printer;
	}

	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
		members.forEach(m -> printer.print(m));
	}

	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
//	public void setMemberPrinter(MemberSummaryPrinter printer) {
//		this.printer = printer;
//	}
	
//	@Autowired
//	@Qualifier("summaryPrinter")
//	@Qualifier("Printer") -
	public void setMemberPrinter(MemberSummaryPrinter printer) { // 타입이 서머리프린터
		this.printer = printer;
	}
	
}
