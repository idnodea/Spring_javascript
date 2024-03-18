package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberPrinter;
import spring.MemberRegisterService;
import spring.MemberSummaryPrinter;
import spring.VersionPrinter;

@Configuration
public class AppCtx {
	
	@Bean
	@Qualifier("printer")
	public MemberDao memberDao() {
		return new MemberDao();
	}
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService();
	}
	@Bean
	public ChangePasswordService changePwdSvc() {
		return new ChangePasswordService();
	}
	
//	@Bean   //-주석처리하고 1,2만들고  같은타입으로 두 개이상 존재하면?
//	@Qualifier("printer")
//	public MemberPrinter memberPrinter() {
//		return new MemberPrinter();
	//}
//	@Bean  //-->qualifier를 사용
//	@Qualifier("printer")
//	public MemberPrinter memberPrinter1() {   //타입 멤버프린터
//		return new MemberPrinter();  
//	}
//	@Bean
//	public MemberPrinter memberPrinter2() {
//		return new MemberPrinter();
//	}
	
	//
	@Bean
	@Qualifier("printer")
	public MemberPrinter memberPrinter1() {
		return new MemberPrinter();
	}
	@Bean
	@Qualifier("summaryPrinter")
	public MemberSummaryPrinter memberPrinter2() {
		return new MemberSummaryPrinter();
	}
	
//	@Bean  //주석처리-오류
//	public void setMemberPrinter(MemberSummaryPrinter printer) {  //타입이 서머리프린터
//		this.printer = printer;
//	}
	
	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter();
	}
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
		return infoPrinter;
	}
	
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
}
