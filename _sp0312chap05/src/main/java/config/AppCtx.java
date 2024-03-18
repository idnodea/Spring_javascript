package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberPrinter;
import spring.MemberSummaryPrinter;
import spring.VersionPrinter;
import spring2.MemberRegisterService;

//@Configuration
//@ComponentScan //
//@ComponentScan(basePackages = {"spring"}) //(안)같은 패키지가 아닐때,  뒤는 패키지 이름
//@ComponentScan(basePackages = {"com.pro.spring",ddd})  경로위치

//@ComponentScan(basePackages = {"spring"},   //정규표현식 0313
//excludeFilters = @Filter(type=FilterType.REGEX, pattern ="spring\\..*Service"))//제외
//@Component

@Configuration
//@ComponentScan(basePackages = {"spring"}) //0313 멤버레지딧 복사대신 옮긴 후 실행-오류
@ComponentScan(basePackages = {"spring,spring2"},  //변경
excludeFilters = @Filter(type = FilterType.ANNOTATION,      //0313 추가
								classes = {NoProduct.class, ManualBean.class})) 
  //0313 추가
public class AppCtx {

	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
//	@Bean  //0313 2교시제외
//	public MemberRegisterService memberRegSvc() {
//		return new MemberRegisterService();
//	}
	
//	@Bean    //3월 12일 2교시 주석처리- 저장 실행
//	public ChangePasswordService changePwdSvc() {
//		return new ChangePasswordService();
//	}
	
//	@Bean
//	@Qualifier("printer")
//	public MemberPrinter memberPrinter() {
//		return new MemberPrinter();
//	}
	
	@Bean
	@Qualifier("printer")
	public MemberPrinter memberPrinter1() {
		return new MemberPrinter();
	}
	
//	@Bean
//	public MemberPrinter memberPrinter2() {
//		return new MemberPrinter();
//	}
	

	@Bean
	@Qualifier("summaryPrinter")
	public MemberSummaryPrinter memberPrinter2() {
		return new MemberSummaryPrinter();
	}
	
	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter();
	}
	
//	@Bean
//	public MemberInfoPrinter infoPrinter() {
//		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
//		infoPrinter.setPrinter(memberPrinter2());  //의존성주입-명시적
//		return infoPrinter;
//	}
	
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
}
