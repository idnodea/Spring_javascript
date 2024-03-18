package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.MemberDao;
import spring.MemberPrinter;

//AppCtx에서 두개를 가져옴
@Configuration
public class AppConf1 {
	
	@Bean//
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean //
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	
}
