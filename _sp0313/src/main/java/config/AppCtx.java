package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import spring.Client;
import spring.Client2;

@Configuration
public class AppCtx {
	
	@Bean
	@Scope("prototype")  //스코프.  변수의 생명주기 말고,  빈의 생명주기관련  //이거 추가 이후 메인3를 돌리면?
	public Client client() {
		Client client = new Client();
		client.setHost("host");
						//
		return client;
	}
	
	@Bean(initMethod = "connect", destroyMethod = "close")
	public Client2 client2() {
		Client2 client = new Client2();
		client.setHost("host");
		return client;
	}

}