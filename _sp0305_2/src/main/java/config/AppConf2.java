package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberPrinter;
import spring.MemberRegisterService;
import spring.VersionPrinter;

@Configuration
public class AppConf2 {
//	@Bean//넘겨주는 게 끝이고, 넘겨준 뒤 책임지지 않는다. 널포인트이셉션등에 책임x
//	public MemberDao memberDao() {
//		return new MemberDao();
//	}
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private MemberPrinter memberPrinter;
	
	@Bean   
	public MemberRegisterService memberRegSvc(){
//		return new MemberRegisterService(memberDao());
		return new MemberRegisterService(memberDao);
	}
	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
//		pwdSvc.setMemberDao(memberDao());
		pwdSvc.setMemberDao(memberDao);
		return pwdSvc;
	}
	
//	@Bean
//	public MemberPrinter memberPrinter() {
//		return new MemberPrinter();
//	}
//	
	@Bean
	public MemberListPrinter listPrinter() {
//		return new MemberListPrinter(memberDao(), memberPrinter());
		return new MemberListPrinter(memberDao, memberPrinter);
		//객체생성하고 그 객체를 이용한 놈을
	}
	
	@Bean
	public MemberInfoPrinter infoPrinter() {
		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
//		infoPrinter.setMemberDao(memberDao());
		infoPrinter.setMemberDao(memberDao);
//		infoPrinter.setPrinter(memberPrinter());
		infoPrinter.setPrinter(memberPrinter);
		return infoPrinter;
		
	}
	
	@Bean
	public VersionPrinter versionPrinter() {
//		VersionPrinter versionPrinter = new VersionPrinter();
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
	
	@Bean
	public VersionPrinter oldversionPrinter() {
//		VersionPrinter versionPrinter = new VersionPrinter();
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(4);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
}