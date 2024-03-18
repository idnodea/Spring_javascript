package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.MyController;
import dao.MemberDao;
import service.GetMemberNumService;

@Configuration
public class ControllerConfig {  //콘트롤러와 콘피그는 원래 별개지만... web.xml고치기가 조금..스프링부트에서 해결하기로

	@Bean
	public MyController myController() {
		return new MyController();
	}
	
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public GetMemberNumService getMemberNumService() {
		return new GetMemberNumService();
	}
}
