package config;


import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberPrinter;
import spring.MemberSummaryPrinter;
import spring.VersionPrinter;
//@Configuration
//@ComponentScan //
//@ComponentScan(basePackages = {"spring"}) //(안)같은 패키지가 아닐때,  뒤는 패키지 이름
//@ComponentScan(basePackages = {"com.pro.spring",ddd})  경로위치

//@ComponentScan(basePackages = {"spring"},   //정규표현식 0313
//excludeFilters = @Filter(type=FilterType.REGEX, pattern ="spring\\..*Service"))//제외
//@Component

//@Configuration
//@ComponentScan(basePackages = {"spring"}) //0313 멤버레지딧 복사대신 옮긴 후 실행-오류
//@ComponentScan(basePackages = {"spring"}) //변경
//excludeFilters = @Filter(type = FilterType.ANNOTATION,      //0313 추가
//								classes = {NoProduct.class, ManualBean.class})) 

@Configuration
@ComponentScan(basePackages = {"spring"})
public class AppCtx {
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost/spring5fs?characterEncoding=utf8");
		ds.setUsername("spring5");
		ds.setPassword("spring5");
		ds.setInitialSize(2);
		ds.setMaxActive(10);
		return ds;
	}
	
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao(dataSource());
	}
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
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
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
//	
//	@Bean
//	@Qualifier("printer")
//	public MemberPrinter memberPrinter1() {
//		return new MemberPrinter();
//	}
//	
////	@Bean
////	public MemberPrinter memberPrinter2() {
////		return new MemberPrinter();
////	}
//	
//
//	@Bean
//	@Qualifier("summaryPrinter")
//	public MemberSummaryPrinter memberPrinter2() {
//		return new MemberSummaryPrinter();
//	}
//	
//	@Bean
//	public MemberListPrinter listPrinter() {
//		return new MemberListPrinter();
//	}
//	
////	@Bean
////	public MemberInfoPrinter infoPrinter() {
////		MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
////		infoPrinter.setPrinter(memberPrinter2());  //의존성주입-명시적
////		return infoPrinter;
////	}
//	
//	@Bean
//	public VersionPrinter versionPrinter() {
//		VersionPrinter versionPrinter = new VersionPrinter();
//		versionPrinter.setMajorVersion(5);
//		versionPrinter.setMinorVersion(0);
//		return versionPrinter;
//	}

